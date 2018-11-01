package org.wecancodeit.bridgeproject.model;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {
	@Id @GeneratedValue private Long id;
	private String abbreviation;
	private String name;
	private String motto;
	@Embedded
	private Fish fish;
	private String citiesUrl;
	@OneToMany(mappedBy="state")
	private Collection<City> cities;
	
	public State() {}




	public State(String abbreviation, String name, String motto, Fish fish, String citiesUrl) {
		super();
		this.abbreviation = abbreviation;
		this.name = name;
		this.motto = motto;
		this.fish = fish;
		this.citiesUrl = citiesUrl;
	}




	public Long getId() {
		return id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getMotto() {
		return motto;
	}

	public Fish getFish() {
		return fish;
	}

	public String getCitiesUrl() {
		return citiesUrl;
	}
	
	public String getName() {
		return name;
	}

	public Collection<City> getCities() {
		return cities;
	}
	
	
	
}

