package com.mic3.exceptions;

public class ResourceNotFoundExc extends RuntimeException{
	
	private static final long serialVersionUID = 8125437631554055445L;
	
	private String name;

    public ResourceNotFoundExc(String name) {
    	this.name = name;
    }

    public ResourceNotFoundExc() {}

    public String getResourceName() {
    	return name;
    }
}
