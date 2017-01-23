package com.arun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arun.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

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
		if (name.equals("") || password.equals("")) {
			map.put("errormessage", "User name and Password are mandatory");
			return "login";
		}
		boolean flag = loginService.validateUser(name, password);
		if (flag == true) {
			map.put("name", name);
			map.put("password", password);
			return "welcome";
		} else {
			map.put("errormessage", "Invalid credentails");
			return "login";
		}
	}
}
