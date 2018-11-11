
package org.wahlzeit.model;

import org.junit.Before;

public class LogoPhotoTest{
	
	private Photo testPhoto;
	
	
	private static String AF = "American Football";
	private static String NATIONAL = "National Football League";
	private static String NFL = "NFL";
	private static String JAX = "Jacksonville Jaguars";
	private static String JV = "Jacksonville";
	private static String USA = "United States of America";
	private static String NOT = "not set";
	
	@Before
	public void init() {
		testPhoto = new LogoPhoto();
		
	}
	
	@Test
	public void testSetAndGetValidValues() {
		testPhoto.setName(JAX);
		testPhoto.setRealTeam(true);
		testPhoto.setSports(AF);
		testPhoto.setLeague(NATIONAL);
		testPhoto.setLeagueShort(NFL);
		testPhoto.setCity(JV);
		testPhoto.setCountry(USA);
		testPhoto.setYear(2018);
		
		assertEquals(testPhoto.getName(), JAX);
		assertEquals(testPhoto.getRealTeam(), true);
		assertEquals(testPhoto.getSports(), AF);
		assertEquals(testPhoto.getLeague(), NATIONAL);
		assertEquals(testPhoto.getLeagueShort(), NFL);
		assertEquals(testPhoto.getCity(), JV);
		assertEquals(testPhoto.getCountry(), USA);
		assertEquals(testPhoto.getYear(), 2018);
		
	}
	
	@Test
	public void testFullConstructor() {
		private Photo completeTestPhoto = new LogoPhoto(JAX, true, AF, NATIONAL, NFL, JV, USA, 2018);
		
		assertEquals(completeTestPhoto.getName(), JAX);
		assertEquals(completeTestPhoto.getRealTeam(), true);
		assertEquals(completeTestPhoto.getSports(), AF);
		assertEquals(completeTestPhoto.getLeague(), NATIONAL);
		assertEquals(completeTestPhoto.getLeagueShort(), NFL);
		assertEquals(completeTestPhoto.getCity(), JV);
		assertEquals(completeTestPhoto.getCountry(), USA);
		assertEquals(completeTestPhoto.getYear(), 2018);
	}
	
	@Test
	public void testInvalidValues() {
		private Photo test = new LogoPhoto();
		test.setLeagueShort("This is invalid!");
		assertEquals(test.getLeagueShort(), "not set");
		
		test.setYear(3000);
		assertEquals(test.getYear(), 0);
	}
	
	@Test
	public void testEmptyValues() {
		private Photo t = new LogoPhoto();
		
		assertEquals(testPhoto.getName(), NOT);
		assertEquals(testPhoto.getRealTeam(), false);
		assertEquals(testPhoto.getSports(), NOT);
		assertEquals(testPhoto.getLeague(), NOT);
		assertEquals(testPhoto.getLeagueShort(), NOT);
		assertEquals(testPhoto.getCity(), NOT);
		assertEquals(testPhoto.getCountry(), NOT);
		assertEquals(testPhoto.getYear(), 0);
	}
}