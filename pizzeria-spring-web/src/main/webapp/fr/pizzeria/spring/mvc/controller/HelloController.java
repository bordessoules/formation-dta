package fr.pizzeria.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String bonjour() {

		return "helloworld";

	}

}