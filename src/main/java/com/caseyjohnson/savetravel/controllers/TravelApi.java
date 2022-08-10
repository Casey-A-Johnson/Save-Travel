package com.caseyjohnson.savetravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caseyjohnson.savetravel.models.Travel;
import com.caseyjohnson.savetravel.services.TravelService;

@RestController
@RequestMapping("/api")
public class TravelApi {
	@Autowired
	private TravelService travelService;
	
	//----Get All-------
	@RequestMapping("/travel")
	public List<Travel> findAllTravelExpenses(){
		return travelService.allTravelExpenses();
	}
	
	//------Create------------
	@PostMapping("/travel")
	public Travel createTravelExpense(
			@RequestParam("name") String name,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String description
			) {
		Travel newTravelExpense = new Travel(name, vendor, amount, description);
		return travelService.createTravelExpense(newTravelExpense);
	}
	
	//-----Find one
	@GetMapping("/travel/{id}")
	public Travel oneTravelExpense(@PathVariable("id")Long id) {
		return travelService.oneTravelExpense(id);
	}
	
	//-----update-------
	@PutMapping("/travel/{id}")
	public Travel editTravelExpense(
			@PathVariable("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String description
			) {
		return travelService.updateTravelExpense(id, name, amount, vendor, description);
	}
	
	//-----delete-----
	@DeleteMapping("/travel/{id}")
	public void removeTravelExpense(@PathVariable("id") Long id) {
		travelService.deleteTravelExpense(id);
	}
	
}
