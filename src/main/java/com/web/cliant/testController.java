package com.web.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	@RequestMapping("/")
	public String index() {
		return "Hello World! Spring boot.";
	}
}
