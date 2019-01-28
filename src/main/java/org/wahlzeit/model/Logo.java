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
	
	/*
	 * true if it is the Logo of an actual team, false if it is a fantasy one
	 */
	public boolean realTeam;
	
	/*
	 * the type of sport of the team of teh specified logo. i.e. Eishockey, American Football, Soccer
	 */
	public String sports;
	
	/*
	 * the league the team is playing in i.e. National Football League; leagueShort i.e. NFL, DEL
	 */
	public String league;
	public String leagueShort;
	
	/**
	 * @methodtype constructor
	 */
	public Logo(LogoType lt) {
		this.team = lt;
	}
	
	public Logo getLogo(LogoType lt) {
		return lt.createInstance();
	}
	
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
	 * @methodtype set
	 */
	public void setRealTeam(boolean value) throws IllegalArgumentException{
	//precondition
	assertArgumentNotNull(value);
	
	this.realTeam = value;
	}
	/**	
	* @methodtype set
	*/
	public void setSports(String inSport) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inSport);
		
		this.sports = inSport;
	}
	
	/**	
	* @methodtype set
	*/
	public void setLeague(String inLeague) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inLeague);
		this.league = inLeague;
	}
	
	/**	
	* @methodtype set
	*/
	public void setLeagueShort(String inLeagueShort) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inLeagueShort);
		
		if(inLeagueShort.length() > 5) {
			//do nothing
		} else {
			this.leagueShort = inLeagueShort;
		}
	}
	
	/**
	 * @methodtype get
	 */
	public LogoType getType() {
		return this.team;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return this.team.getName();
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
	 * @methodtype get
	 */
	public boolean getRealTeam() {
		return this.realTeam;
	}
	
	/**
	 * @methodtype get
	 */
	public String getSports() {
		return this.sports;
	}
	
	/**
	 * @methodtype get
	 */
	public String getLeague() {
		return this.league;
	}
	
	/**
	 * @methodtype get
	 */
	public String getLeagueShort() {
		return this.leagueShort;
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