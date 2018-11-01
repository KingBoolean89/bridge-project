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
	
	@GetMapping("/api/states/{abbr}")
	public State showAState(@PathVariable(value = "abbr") String abbr) {
		//This method comes from the StateRepository class, it's a JPA query
		return stateRepo.findByAbbreviationIgnoreCase(abbr);
	}
	
	@GetMapping("/api/states/{abbr}/cities")
	public Collection<City> showStateCities(@PathVariable(value = "abbr") String abbr) {
		return stateRepo.findByAbbreviationIgnoreCase(abbr).getCities();
	}
	
}
