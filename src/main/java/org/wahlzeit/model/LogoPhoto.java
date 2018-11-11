
package org.wahlzeit.model;

public class LogoPhoto extends Photo {
	
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
	protected String coutry;
	
	/*
	 * the year the logo was designed
	 */
	protected int year;
	
	/*
	 * basic constructor, barely does anything
	 */
	public LogoPhoto() {
		this.realTeam = false;
		this.year = 0;
		
	}
	
	/*
	 * full constructor
	 */
	public LogoPhoto(boolean inRealTeam, String inSports, String inLeague,
			String inLeagueShort, String inCity, String cinCountry, int inYear) {
		this.realTeam = inRealTeam;
		this.sports = inSports;
		this.league = inLeague;
		this.leagueShort = inLeagueShort;
		this.city = inCity;
		this.country = inCountry;
		this.year = inYear;
	}
	
	/*
	 * public setters
	 */
	public void setRealTeam(boolean value) {
		this.realTeam = value;
	}
	
	public void setSports(String inSport) {
		this.sports = inSport;
	}
	
	public void setLeague(String inLeague) {
		this.league = inLeague;
	}
	
	public void setLeagueShort(String inLeagueShort) {
		this.leagueShort = inLeagueShort;
	}
	
	public void setCity(String inCity) {
		this.city = inCity;
	}
	
	public void setCountry(String inCountry) {
		this.country = inCountry
	}
	
	public void setYear(int inYear) {
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
	public boolean isRealTeam() {
		return this.realTeam;
	}
	
	public String getSports() {
		if(this.sports == null) {
			return "not set";
		}
		return this.sports;
	}
	
	public String getLeague() {
		if(this.league == null) {
			return "not set";
		}
		return this.league
	}
	
	public String getLeagueShort() {
		if(this.leagueShort == null) {
			return "not set";
		}
		return this.leagueShort;
	}
	
	public String getCity() {
		if(this.city == null) {
			return "not set";
		}
		return this.city;
	}
	
	public String getCountry() {
		if(this.country == null) {
			return "not set";
		}
		return this.country;
	}
	
	public int getYear() {
		return this.year;
	}
				
	
}