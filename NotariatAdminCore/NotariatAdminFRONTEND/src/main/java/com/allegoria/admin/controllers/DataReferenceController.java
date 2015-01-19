package com.allegoria.admin.controllers; 


import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





/**
 * Application home page and login.
 */
@Controller
@RequestMapping("/data")
public class DataReferenceController {
	
    
	@RequestMapping("/office")
    public String adminCompanies(ModelMap model) {
    	
    	return "office/newoffice.html";
    }

	   
	 
	    
    
}
