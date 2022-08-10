package com.caseyjohnson.savetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caseyjohnson.savetravel.models.Travel;
import com.caseyjohnson.savetravel.repositories.TravelRepository;

@Service
public class TravelService {
	@Autowired
	private TravelRepository travelRepo;
	
	//------find all travel expenses
	public List<Travel> allTravelExpenses(){
		return travelRepo.findAll();
	}
	
	//------create travel expense
	public Travel createTravelExpense(Travel expense) {
		return travelRepo.save(expense);
	}
	
	//------Find One
	public Travel oneTravelExpense(Long id) {
		Optional<Travel> optionalTravelExpense = travelRepo.findById(id);
		if(optionalTravelExpense.isPresent()) {
			return optionalTravelExpense.get();
		}else {
			return null;
		}
	}
	
	//----update one
	public Travel updateTravelExpense(Travel expense) {
		return travelRepo.save(expense);
	}
	
	//----update one for api
	public Travel updateTravelExpense(Long id, String name, Integer amount, String vendor, String description) {
		Travel foundTravelExpense = this.oneTravelExpense(id);
		foundTravelExpense.setName(name);
		foundTravelExpense.setAmount(amount);
		foundTravelExpense.setVendor(vendor);
		foundTravelExpense.setDescription(description);
		return travelRepo.save(foundTravelExpense);
	}
	
	//----Delete
	public void deleteTravelExpense(Long id) {
		travelRepo.deleteById(id);
	}
}
