package com.mic3.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/", "/homepage"})
public class HomeController {
	
	@PreAuthorize("hasIpAddress('49.2.124.45')") // Testing purpose: use some user priviledges logic
	@RequestMapping(method=GET)
	public String home() {
		return "home";
	}
}
