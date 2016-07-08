package servlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class HelloFreeMarkerServlet extends HttpServlet {
    // 负责管理FreeMarker模板的Configuration实例  
    private Configuration cfg = null;

    public void init() throws ServletException {
        // 创建一个FreeMarker实例  
        cfg = new Configuration();
        // 指定FreeMarker模板文件的位置  
        cfg.setServletContextForTemplateLoading(getServletContext(),
                "/WEB-INF/templates");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 建立数据模型  
        Map root = new HashMap();
        root.put("message", "hello world");
        root.put("name", "java小强");
        // 获取模板文件  
        Template t = cfg.getTemplate("test.ftl", "UTF-8");  //指定按UTF-8读，不然乱码
        // 使用模板文件的Charset作为本页面的charset  
        // 使用text/html MIME-type  
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        Writer out = response.getWriter();
        // 合并数据模型和模板，并将结果输出到out中  
        try {
            t.process(root, out); // 往模板里写数据  
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void destroy() {
        super.destroy();
    }
}  