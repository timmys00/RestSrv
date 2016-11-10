package com.mic3.interceptors;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class RequestInterceptor implements WebRequestInterceptor  {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		System.out.println("---PreHandle---");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---PostHandle---");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---After Complete---");
	}

}
