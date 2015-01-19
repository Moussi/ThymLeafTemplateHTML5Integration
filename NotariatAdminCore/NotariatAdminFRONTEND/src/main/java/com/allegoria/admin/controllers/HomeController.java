package com.allegoria.admin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	 @RequestMapping("/")
	    public String root() {
	        return "index.html";
	    }

	 /** Login form. */
	    @RequestMapping("/login.html")
	    public String login() {
	        return "signin.html";
	    }

	    /** Login form with error. */
	    @RequestMapping("/login-error.html")
	    public String loginError(Model model) {
	        model.addAttribute("loginError", true);
	        //return "login.html";
	        return "signin.html";
	    }
	    /* Home page. */
	    @RequestMapping("/welcome")
	    public String index() {
	        return "welcome.html";
	    }
	    
	    /* Home page. */
	    @RequestMapping("/error")
	    public String error() {
	        return "error.html";
	    }
	    @RequestMapping("/404")
	    public String pagenotfound() {
	        return "404.html";
	    }
}