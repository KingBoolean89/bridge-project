package org.wecancodeit.bridgeproject.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.bridgeproject.model.City;
import org.wecancodeit.bridgeproject.model.State;
import org.wecancodeit.bridgeproject.repositories.StateRepository;

@RestController
public class ApiController {
	
	@Autowired
	StateRepository stateRepo;
	
	@GetMapping("/api/states")
	public Iterable<State> showStates() {
		return stateRepo.findAll();
	}
	
//	@GetMapping("/api/states/{id}")
//	public State showStates(@PathVariable(value = "id") Long id) {
//		return stateRepo.findById(id).get();
//	}
	
	//FUCKING OPTIONALS FUCKING EVERYTHING UP AGAIN!
	@GetMapping("/api/states/{abbr}")
	public State showStates(@PathVariable(value = "abbr") String abbr) {
		Long id = 0L;
		for(State state : stateRepo.findAll()) {
			if(state.getAbbreviation().equals(abbr)) {
				id = state.getId();
			}
		}
		return stateRepo.findById(id).get();
	}
//	
//
//	@GetMapping("/api/states/{abbr}/cities")
//	public Collection<City> listCities(@PathVariable(value = "abbr") String abbr) {
//		Long id = 0L;
//		for(State state : stateRepo.findAll()) {
//			if(state.getAbbreviation().equals(abbr)) {
//				id = state.getId();
//			}
//		}
//		return stateRepo.findById(id).get().getCities();
//	}
	
	
	
}
