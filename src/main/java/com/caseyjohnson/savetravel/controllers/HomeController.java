package com.caseyjohnson.savetravel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caseyjohnson.savetravel.models.Travel;
import com.caseyjohnson.savetravel.services.TravelService;

@Controller
public class HomeController {
	
	@Autowired
	private TravelService travelService;
	
	//----Get All-----------
	@RequestMapping("/travel")
	public String dashboard(Model model) {
		List<Travel> travelExpenses = travelService.allTravelExpenses();
		model.addAttribute("travelList", travelExpenses);
		model.addAttribute("travelExpense", new Travel());
		return "dashboard.jsp";
	}
	
	//-----Create----------------
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
	
	//---------Edit---------
	@RequestMapping("/travel/edit/{id}")
	public String renderEditPage(@PathVariable("id")Long id, Model model) {
		Travel foundTravelExpense = travelService.oneTravelExpense(id);
		model.addAttribute("travelExpense", foundTravelExpense);
		return "editPage.jsp";
	}
	
	@PutMapping("/process/edit/{id}")
	public String processEdit(
			@Valid
			@ModelAttribute("travelExpense") Travel travelExpense,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "editPage.jsp";
		} else {
			travelService.updateTravelExpense(travelExpense);
			return "redirect:/travel";
		}
	}
	
	//-------Delete---------------------
	@DeleteMapping("/travel/delete/{id}")
	public String processDelete(@PathVariable("id")Long id) {
		travelService.deleteTravelExpense(id);
		return "redirect:/travel";
	}
	
}
