package com.noname.interest.SpringBootCrudDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Hello world !!!");
		return "index";
	}
}
