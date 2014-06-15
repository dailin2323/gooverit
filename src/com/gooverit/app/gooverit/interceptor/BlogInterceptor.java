package com.gooverit.app.gooverit.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * @Project: gooverit
 * @Title: BlogInterceptor.java
 * @Package com.gooverit.app.gooverit.interceptor
 * @Description: BlogInterceptor.java
 * @author Turbo,Email:dailin2323@gmail.com
 * @date 2014年6月15日 下午11:26:05
 * @Copyright: 2014 
 * @version V1.0
 */
public class BlogInterceptor implements Interceptor {
	
	public void intercept(ActionInvocation ai) {
		System.out.println("Before invoking " + ai.getActionKey());
		ai.invoke();
		System.out.println("After invoking " + ai.getActionKey());
	}
}
