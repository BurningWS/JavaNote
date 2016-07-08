package servlet;

import client.ProcessClient;
import service.UserService;
import util.DirectoryFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

public class DelUser extends HttpServlet {


        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            this.doPost(request, response);
        }

        //删除用户
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String id = request.getParameter("id");
            UserService.delete(Integer.valueOf(id));

            //生成html的位置
            String dirPath = request.getSession().getServletContext().getRealPath("/templates/html");
            //文件名字
            String indexFileName = "index.html";

            //删除原来的文件
            delOldHtml(dirPath,indexFileName);

            //防止浏览器缓存，用于重新生成新的html
            UUID uuid = UUID.randomUUID();
            Writer out = new OutputStreamWriter(new FileOutputStream(dirPath+"/"+uuid+indexFileName),"UTF-8");
            ProcessClient.processBody(out);
            response.sendRedirect("templates/html/"+uuid+"index.html");
        }

        /**
         * 删除原来的html文件
         * @param htmlDir
         * @param htmlName
         */
        private void delOldHtml(String htmlDir,String htmlName){
            File path = new File(htmlDir);
            String[] indexfileList = path.list(new DirectoryFilter(htmlName));
            if(indexfileList.length>=0){
                for(String f:indexfileList){
                    File delf = new File(htmlDir+"/"+f);
                    delf.delete();
                }
            }
        }

    }