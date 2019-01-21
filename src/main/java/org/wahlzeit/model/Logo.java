package org.wahlzeit.model;

import java.util.*;

public class Logo {
	/*
	 * team name
	 */
	public LogoType team;
	
	/*
	 * the city the team is located in
	 */
	public String city;
	
	/*
	 * the country the team is located in
	 */
	public String country;
	
	/*
	 * the year the logo was designed
	 */
	public int year;
	
	
	
	/**
	 * @methodtype set
	 */
	public void setTeam(LogoType inTeam) throws IllegalArgumentException {
		assertArgumentNotNull(inTeam);
		this.team = inTeam;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCity(String inCity) throws IllegalArgumentException {
		assertArgumentNotNull(inCity);
		this.city = inCity;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCountry(String inCountry) throws IllegalArgumentException {
		assertArgumentNotNull(inCountry);
		this.country = inCountry;
	}
	/**
	 * @methodtype set
	 */
	public void setYear(int inYear) {
		int currYear = Calendar.getInstance().get(Calendar.YEAR); //https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
		if(inYear > currYear || inYear < 0) {
			this.year = 0;
		}else {
			this.year = inYear;
		}
	}
	
	/**
	 * @methodtype get
	 */
	public LogoType getTeam() {
		return this.team;
	}
	
	/**
	 * @methodtype get
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * @methodtype get
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * @methodtype get
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertArgumentNotNull(Object o) {
		if(o == null) {
			throw new IllegalArgumentException("No argument provided!");
		}
	}
}