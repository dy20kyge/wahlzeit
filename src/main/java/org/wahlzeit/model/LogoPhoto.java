
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
	 * basic constructor, barely does anything
	 */
	public LogoPhoto() {
		
	}
	
	/*
	 * full constructor
	 */
	public LogoPhoto(boolean real, String sport, String leag, String leagShort, String cit, String contry) {
		this.realTeam = real;
		this.sports = sport;
		this.league = leag;
		this.leagueShort = leagShort;
		this.city = cit;
		this.country = contry;
	}
	
}