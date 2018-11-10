
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
	
}