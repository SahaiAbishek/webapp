package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDaoImpl;
import com.example.demo.model.User;

@Controller
public class FormController {

	@Autowired
	UserDaoImpl userDao;
	
	@RequestMapping(value="/details",method=RequestMethod.POST )
	public ModelAndView submitdetails(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") User user) throws Exception{
		
		System.out.println(user.getProvFirstName());
		System.out.println(user.getMyfile().getOriginalFilename());
		userDao.addUser(user);
		return new ModelAndView("index");
	}
}
