package org.wahlzeit.model;

public class LogoType {
	
	/*
	 * the name of the team
	 */
	public String name;
	
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
	 * @methodtype set
	 */
	public void setName(String inName) throws IllegalArgumentException {
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
	 * @methodtype assertions
	 */
	private void assertArgumentNotNull(Object o) {
		if(o == null) {
			throw new IllegalArgumentException("No argument provided!");
		}
	}
}