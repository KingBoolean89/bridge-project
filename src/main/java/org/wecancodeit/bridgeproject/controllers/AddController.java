package org.wecancodeit.bridgeproject.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.bridgeproject.model.City;
import org.wecancodeit.bridgeproject.repositories.CityRepository;
import org.wecancodeit.bridgeproject.repositories.StateRepository;

@Controller
public class AddController {

	@Resource StateRepository stateRepo;
	@Resource CityRepository cityRepo;
	
	@RequestMapping("/")
	public String showHome() {
		return "redirect:/states";
	}
	
	@RequestMapping("/states")
	public String showStates(Model model) {
		model.addAttribute("states", stateRepo.findAll());
		return "states";
	}
	
	@RequestMapping("/states/{id}")
	public String showAState(@PathVariable(value="id")Long id, Model model) {
		model.addAttribute("state", stateRepo.findById(id).get());
		return "state";
	}
	
	@RequestMapping("/states/{id}/add-city")
	public String showAddCity(@PathVariable(value="id")Long id, Model model) {
		model.addAttribute("id", id);
		return "add-city";
	}
	
	@PostMapping("/states")
	public String addCity(Model model, String cityName, int cityPop, Long stateId) {
		cityRepo.save(new City(cityName, cityPop, stateRepo.findById(stateId).get()));
		return "redirect:/states";
	}
	
}
