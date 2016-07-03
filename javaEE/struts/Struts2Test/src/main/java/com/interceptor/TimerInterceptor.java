package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by wangsong09 on 2016/5/1.
 */
public class TimerInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        long s = System.currentTimeMillis();
        String r = invocation.invoke();
        System.out.println("time:" + (System.currentTimeMillis() - s));
        return r;
    }
}
