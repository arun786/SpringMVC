package com.arun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/logins")
	@ResponseBody /* This will serve as payload for the page */
	public String getLoginPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPages(ModelMap map, @RequestParam String name, @RequestParam String password) {
		map.put("name", name);
		map.put("password", password);
		return "welcome";
	}

}
