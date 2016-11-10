package com.mic3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="City Not Found")
public class CityNotFoundException extends RuntimeException{

}
