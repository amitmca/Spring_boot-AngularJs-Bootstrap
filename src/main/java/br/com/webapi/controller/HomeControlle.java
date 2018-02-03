package br.com.webapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControlle {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
