package com.mic3.interceptors;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CallableRequestInterceptor implements CallableProcessingInterceptor  {
	
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---LI - beforeConcurrentHandling---");
	}
	@Override
	public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---LI - preProcess---");
		
	}
	@Override
	public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---LI - postProcess---");
		
	}
	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---LI - handleTimeout---");
		return null;
	}
	@Override
	public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---LI - afterCompletition---");
		
	}
	
} 