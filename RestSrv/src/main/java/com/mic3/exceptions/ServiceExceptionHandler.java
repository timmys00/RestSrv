package com.mic3.exceptions;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class ServiceExceptionHandler {

    @Value("${resourceNotFound}")
    private String notFound;

    @Value("${databaseError}")
    private String dbError;

    @ExceptionHandler(ResourceNotFoundExc.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntityErr resourceNotFound(ResourceNotFoundExc e) {
		String name = e.getResourceName();
		if (name == null) {
		    return new ResponseEntityErr(404, notFound);
		}
		return new ResponseEntityErr(404, notFound + " : " + name);
    }

    @ExceptionHandler({ DataAccessException.class, RestClientException.class })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntityErr databaseError(NestedRuntimeException ex) {
    	return new ResponseEntityErr(6, ex.getRootCause().getMessage());
    }

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntityErr commonError(Exception ex) {
    	return new ResponseEntityErr(10, ex.getMessage());
    }
    
    @ExceptionHandler({ SQLException.class })
    public ResponseEntityErr sqlError(SQLException ex) {
    	return new ResponseEntityErr(10, ex.getMessage());
    }
}
