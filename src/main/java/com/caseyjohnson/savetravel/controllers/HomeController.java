package com.caseyjohnson.savetravel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caseyjohnson.savetravel.models.Travel;
import com.caseyjohnson.savetravel.services.TravelService;

@Controller
public class HomeController {
	
	@Autowired
	private TravelService travelService;
	
	@RequestMapping("/travel")
	public String dashboard(Model model) {
		List<Travel> travelExpenses = travelService.allTravelExpenses();
		model.addAttribute("travelList", travelExpenses);
		model.addAttribute("travelExpense", new Travel());
		return "dashboard.jsp";
	}
	
	@PostMapping("/travel/add")
	public String processCreate(
			@Valid
			@ModelAttribute("travelExpense") Travel travelExpense,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			List<Travel> travelExpenses = travelService.allTravelExpenses();
			model.addAttribute("travelList", travelExpenses);
			return "dashboard.jsp";
		}else {
			travelService.createTravelExpense(travelExpense);
			return "redirect:/travel";
		}
	}
	
	
}
