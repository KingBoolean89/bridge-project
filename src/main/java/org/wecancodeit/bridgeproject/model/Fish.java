package org.wecancodeit.bridgeproject.model;

import javax.persistence.Embeddable;

@Embeddable
public class Fish {
	private String fishName;
	private String binomialNomencluture;
	private String imgUrl;
	
	public Fish() {}

	public Fish(String name, String binomialNomencluture, String imgUrl) {
		this.fishName = name;
		this.binomialNomencluture = binomialNomencluture;
		this.imgUrl = imgUrl;
	}

//	public Long getId() {
//		return id;
//	}

	public String getfishName() {
		return fishName;
	}

	public String getBinomialNomencluture() {
		return binomialNomencluture;
	}

	public String getImgUrl() {
		return imgUrl;
	}

}
