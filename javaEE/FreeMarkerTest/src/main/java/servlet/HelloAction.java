package servlet;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wangsong09 on 2016/5/9.
 */
public class HelloAction extends ActionSupport {

    Integer id;
    String name;

    @Override
    public String execute() throws Exception {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        return SUCCESS;
    }
}
