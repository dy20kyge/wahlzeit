
package org.wahlzeit.model;

import java.util.*;
import java.util.logging.Logger;
import org.wahlzeit.services.LogBuilder;

public class LogoPhoto extends Photo {
	
	//logger
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());
	
	/*
	 * team name
	 */
	protected String name;
	
	/*
	 * true if it is the Logo of an actual team, false if it is a fantasy one
	 */
	protected boolean realTeam;
	
	/*
	 * the type of sport of the team of teh specified logo. i.e. Eishockey, American Football, Soccer
	 */
	protected String sports;
	
	/*
	 * the league the team is playing in i.e. National Football League; leagueShort i.e. NFL, DEL
	 */
	protected String league;
	protected String leagueShort;
	
	/*
	 * the city the team is located in
	 */
	protected String city;
	
	/*
	 * the country the team is located in
	 */
	protected String country;
	
	/*
	 * the year the logo was designed
	 */
	protected int year;
	
	/**	
	* @methodtype constructor
	*/
	public LogoPhoto() {
		this.realTeam = false;
		this.year = 0;
		
	}
	
	/**	
	* @methodtype constructor
	*/
	public LogoPhoto(String inName, boolean inRealTeam, String inSports, String inLeague,
			String inLeagueShort, String inCity, String inCountry, int inYear){
		
		//preconditions arguments are checked in setters
		try {
			this.setName(inName);
			this.setRealTeam(inRealTeam);
			this.setSports(inSports);
			this.setLeague(inLeague);
			this.setLeagueShort(inLeagueShort);
			this.setCity(inCity);
			this.setCountry(inCountry);
			this.setYear(inYear); 
		} catch (Exception e) {
			log.warning(LogBuilder.createSystemMessage().
					addException("Problem with photo creation", e).toString());
		}
	}
	
	/*
	 * public setters
	 */
	/**
	 * @methodtype set
	 */
	public void setName(String inName) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inName);
		
		this.name = inName;
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
	* @methodtype set
	*/
	public void setCity(String inCity) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inCity); 
		
		this.city = inCity;
	}
	
	/**	
	* @methodtype set
	*/
	public void setCountry(String inCountry) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inCountry);
		
		this.country = inCountry;
	}
	
	/**	
	* @methodtype set
	*/
	public void setYear(int inYear) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inYear);
		
		int currYear = Calendar.getInstance().get(Calendar.YEAR); //https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
		if(inYear > currYear || inYear < 0) {
			this.year = 0;
		}else {
			this.year = inYear;
		}
	}
	
	/*
	 * public getters
	 */
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		if(this.name == null) {
			return "not set";
		}
		return this.name;
	}
	/**	
	* @methodtype get
	*/
	public boolean isRealTeam() {
		return this.realTeam;
	}
	
	/**	
	* @methodtype get
	*/
	public String getSports() {
		if(this.sports == null) {
			return "not set";
		}
		return this.sports;
	}
	
	/**	
	* @methodtype get
	*/
	public String getLeague() {
		if(this.league == null) {
			return "not set";
		}
		return this.league;
	}
	
	public String getLeagueShort() {
		if(this.leagueShort == null) {
			return "not set";
		}
		return this.leagueShort;
	}
	
	/**	
	* @methodtype get
	*/
	public String getCity() {
		if(this.city == null) {
			return "not set";
		}
		return this.city;
	}
	
	/**	
	* @methodtype get
	*/
	public String getCountry() {
		if(this.country == null) {
			return "not set";
		}
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