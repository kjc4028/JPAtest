package com.example.mvc.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.entity.City;
import com.example.mvc.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Inject
	protected CityService cityService;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<City> list = cityService.findAll();
		model.addAttribute("list", list);
		return "/city/list";
	}

}
