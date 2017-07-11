package com.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.User;
import com.mvc.model.UserCredentials;
import com.mvc.service.LoginService;

@Controller
public class WellcomeController {
	@Autowired
	LoginService loginService; 
	
	
	@RequestMapping(value = {"/","index"})
	public String indexLoad(){
		return "index" ;
	}

	@RequestMapping(value ="loginLoad")
	public ModelAndView loginLoad (){
		return new ModelAndView("loginPage");
	}
	@RequestMapping(value = "login",method =RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("userCredentials") UserCredentials userCredentials ) {
		if(loginService.userAuthentication(userCredentials))
		{
		//	Map<String, String> model = new HashMap<String, String>();
		//	model.put("user", userCredentials.getUserId());
			 String message = "HELLO SPRING MVC HOW R U"; 
			return new ModelAndView("welcome","model",message);
			
		}
		return new ModelAndView("loginPage");
	}
	@RequestMapping(value ="registrationPage")
	public String registrationLoad(){
		return "registration";
	}
	/*@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView userRegistration(@ModelAttribute("user") User user ){
		
		
	}*/
}