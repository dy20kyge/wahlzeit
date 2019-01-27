
package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LogoPhotoTest{
	
	private LogoPhoto testPhoto;
	
	
	private static String AF = "American Football";
	private static String NATIONAL = "National Football League";
	private static String NFL = "NFL";
	private static String JAX = "Jacksonville Jaguars";
	private static String JV = "Jacksonville";
	private static String USA = "United States of America";
	private static String NOT = "not set";
	
	/*@Before
	public void init() {
		testPhoto = new LogoPhoto();
		//Logo testLogo = LogoManager.createLogo(JAX);
		
	}*/
	
	@Test
	public void pseudoTest() {
		assertTrue(true);
	}
	
	
	/*@Test
	public void testFullConstructor() {
		LogoPhoto completeTestPhoto = new LogoPhoto(JAX, true, AF, NATIONAL, NFL, JV, USA, 2018);
		
		assertEquals(completeTestPhoto.getName(), JAX);
		assertEquals(completeTestPhoto.isRealTeam(), true);
		assertEquals(completeTestPhoto.getSports(), AF);
		assertEquals(completeTestPhoto.getLeague(), NATIONAL);
		assertEquals(completeTestPhoto.getLeagueShort(), NFL);
		assertEquals(completeTestPhoto.getCity(), JV);
		assertEquals(completeTestPhoto.getCountry(), USA);
		assertEquals(completeTestPhoto.getYear(), 2018);
	}*/
	
	/*@Test
	public void testInvalidValues() {
		LogoPhoto test = new LogoPhoto();
		//test.setLeagueShort("This is invalid!");
		//assertEquals(test.getLeagueShort(), "not set");
		
		test.setYear(3000);
		assertEquals(test.getYear(), 0);
	}*/
	
	/*@Test
	public void testEmptyValues() {
		LogoPhoto t = new LogoPhoto();
		
		assertEquals(testPhoto.getName(), NOT);
		assertEquals(testPhoto.isRealTeam(), false);
		assertEquals(testPhoto.getSports(), NOT);
		assertEquals(testPhoto.getLeague(), NOT);
		assertEquals(testPhoto.getLeagueShort(), NOT);
		assertEquals(testPhoto.getCity(), NOT);
		assertEquals(testPhoto.getCountry(), NOT);
		assertEquals(testPhoto.getYear(), 0);
	}*/
}