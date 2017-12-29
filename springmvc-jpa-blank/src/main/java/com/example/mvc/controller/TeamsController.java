package com.example.mvc.controller;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.entity.Person;
import com.example.mvc.entity.Teams;
import com.example.mvc.service.TeamsService;

@Controller
@RequestMapping("/teams")
public class TeamsController {
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;
	@Inject
	protected TeamsService teamsService;
	
	@RequestMapping(value="/list")
	public String list(@RequestParam(value="page", required = false) Integer page, Model model){
		int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
		Page<Teams> paging = teamsService.findAll(pageNum, DEFAULT_PAGE_SIZE);
		model.addAttribute("page", paging);
		return "/teams/list";
	}
	
	@RequestMapping(value="/edit/{teamId}", method = RequestMethod.GET)
	public String editOnSubmit(@PathVariable(value="teamId") Integer teamId, Model model){
		Teams teams = teamsService.findById(teamId);;
		model.addAttribute("teams", teams);
		return "/teams/form";
	}
	
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editOnSubmit(@Valid Teams teams,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAllAttributes(bindingResult.getModel());
            return "/teams/form";
        }
        teamsService.update(teams);
        System.out.println("edit finish...");
        return "redirect:/teams/list";
    }
	
	  @RequestMapping(value = "/form", method = RequestMethod.GET)
	    public @ModelAttribute Teams create(Model model) {
		  Teams teams = new Teams();
	        return teams;
	    }
	  
	  @RequestMapping(value = "/form", method = RequestMethod.POST)
	    public String createOnSubmit(@Valid Teams teams,
	            BindingResult bindingResult, Model model) {
		  
	        if (bindingResult.hasErrors()) {
	            model.addAllAttributes(bindingResult.getModel());
	            return "/teams/form";
	        }
	        teamsService.insert(teams);
	        return "redirect:/teams/list";
	    }
	  
	    @RequestMapping(value = "/delete/{id}")
	    public String delete(
	            @RequestParam(value = "page", required = false) Integer page,
	            @PathVariable("id") Integer id) {
	    	teamsService.delete(id);

	        return "redirect:/teams/list";
	    }
	
}
