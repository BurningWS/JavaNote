package com.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wangsong09 on 2016/4/30.
 */
public class HelloAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("HelloAction!!");
        Thread.sleep(1000);
        System.out.println("end..");
        return SUCCESS;
    }
}
