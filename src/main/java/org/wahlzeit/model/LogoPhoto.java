
package org.wahlzeit.model;


import java.util.logging.Logger;
import org.wahlzeit.services.LogBuilder;

@PatternInstance(
	 patternName = "Factory",
	 participants = { "PhotoFactory", "LogoPhotoFactory", "Photo", "LogoPhoto"}
)

public class LogoPhoto extends Photo {
	
	//logger
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());
	
	
	/*
	 * a typeObject to identify the image content
	 */
	protected Logo pictureContent;
	
	
	/**	
	* @methodtype constructor
	*/
	public LogoPhoto() {
		
		
	}
	
	/**	
	* @methodtype constructor
	*/
	public LogoPhoto(Logo inLogo, String inCity, String inCountry, int inYear){
		
		//preconditions arguments are checked in setters
		try {
			this.setLogo(inLogo);
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
	public void setLogo(Logo inLogo) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inLogo);
		
		this.pictureContent = inLogo;
	}
	
	
	/**	
	* @methodtype set
	*/
	public void setCity(String inCity) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inCity); 
		
		pictureContent.setCity(inCity);
	}
	
	/**	
	* @methodtype set
	*/
	public void setCountry(String inCountry) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inCountry);
		
		pictureContent.setCountry(inCountry);
	}
	
	/**	
	* @methodtype set
	*/
	public void setYear(int inYear) throws IllegalArgumentException{
		//precondition
		assertArgumentNotNull(inYear);
		
		pictureContent.setYear(inYear);
	}
	
	/*
	 * public getters
	 */
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		if(this.pictureContent.team.name == null) {
			return "not set";
		}
		return this.pictureContent.getName();
	}
	/**	
	* @methodtype get
	*/
	public boolean isRealTeam() {
		return this.pictureContent.realTeam;
	}
	
	/**	
	* @methodtype get
	*/
	public String getSports() {
		if(this.pictureContent.sports == null) {
			return "not set";
		}
		return this.pictureContent.sports;
	}
	
	/**	
	* @methodtype get
	*/
	public String getLeague() {
		if(this.pictureContent.league == null) {
			return "not set";
		}
		return this.pictureContent.league;
	}
	
	public String getLeagueShort() {
		if(this.pictureContent.leagueShort == null) {
			return "not set";
		}
		return this.pictureContent.leagueShort;
	}
	
	/**	
	* @methodtype get
	*/
	public String getCity() {
		if(this.pictureContent.city == null) {
			return "not set";
		}
		return this.pictureContent.city;
	}
	
	/**	
	* @methodtype get
	*/
	public String getCountry() {
		if(this.pictureContent.country == null) {
			return "not set";
		}
		return this.pictureContent.country;
	}
	
	/**	
	* @methodtype get
	*/
	public int getYear() {
		return this.pictureContent.year;
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