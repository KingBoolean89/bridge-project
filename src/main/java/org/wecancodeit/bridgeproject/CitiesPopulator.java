package org.wecancodeit.bridgeproject;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.bridgeproject.model.City;
import org.wecancodeit.bridgeproject.model.Fish;
import org.wecancodeit.bridgeproject.model.State;
import org.wecancodeit.bridgeproject.repositories.CityRepository;
import org.wecancodeit.bridgeproject.repositories.StateRepository;

@Service
public class CitiesPopulator implements CommandLineRunner {

		@Resource
		CityRepository cityRepo;
		
		@Resource
		StateRepository stateRepo;

		@Override
		public void run(String... args) throws Exception {
			State ohio = new State("OH", "Ohio", "Birthplace of Aviation", null, "/api/states/oh/cities");
			ohio = stateRepo.save(ohio);
			City columbus = new City("Columbus", 100, ohio);
			columbus = cityRepo.save(columbus);
			
			Fish cornfish = new Fish("Cornfish", "Icthius mays", "IMGURL");
			State indiana = new State("IN", "Indiana", "Land of Lincoln-Adjancent", cornfish, "/api/states/in/cities");
			indiana = stateRepo.save(indiana);
			City muncie = new City("Muncie", 12, indiana);
			muncie = cityRepo.save(muncie);
		}
		
		
}
