package com.vcit.country;

public class CountryInfo {
	
	private String alpha2Code;
	private String name;
	private String capital;
	

	public String getAlpha2Code() {
		return alpha2Code;
	}
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	@Override
	public String toString() {
		return "CountryInfo [alpha2Code=" + alpha2Code + ", name=" + name + ", capital=" + capital + "]";
	}
	
	
}
