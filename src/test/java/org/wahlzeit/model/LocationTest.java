package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest{
	
	@Test
	public void testSetAndGetCartesian() {
		CartesianCoordinate c = new CartesianCoordinate(0, 0, 1);
		Location loc = new Location(c);
		CartesianCoordinate check = (CartesianCoordinate) loc.getCoordinate();
		assertEquals(check, c);
	}
	
	@Test
	public void testEqualsCartesian() {
		CartesianCoordinate c0 = new CartesianCoordinate(0, 0, 1);
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 1);
		assertTrue(c0.isEqual(c1));
	}
	
	@Test
	public void testDistanceCartesian() {
		CartesianCoordinate c0 = new CartesianCoordinate(0, 0, 1);
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		assertTrue(c0.getCartesianDistance(c1) == 1.0);
	}
	
	@Test
	public void testDistance2Cartesian() {
		CartesianCoordinate c0 = new CartesianCoordinate(2, 2, 1);
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		assertTrue(c0.getCartesianDistance(c1) ==3.0);
	}
	
	@Test
	public void testAsCartesianAndIsEqual() {
		CartesianCoordinate checkCoordinate = new CartesianCoordinate(0.0, 0.0, 0.0);
		Coordinate test1 = new CartesianCoordinate(0.0, 0.0, 0.0);
		Coordinate test2 = new SphericCoordinate(0.0, 0.0, 0.0);
		CartesianCoordinate test1C = (CartesianCoordinate) test1;
		assertTrue(checkCoordinate.isEqual(test1C));
		CartesianCoordinate test2C = test2.asCartesianCoordinate();
		assertTrue(checkCoordinate.isEqual(test2C));
		checkCoordinate = new CartesianCoordinate(0.0, 0.0, 1.0);
		Coordinate test3 = new SphericCoordinate(0.0, 0.0, 1.0);
		CartesianCoordinate test3C = test3.asCartesianCoordinate();
		assertTrue(checkCoordinate.isEqual(test3C));

	}
	
	@Test
	public void testIsEqual() {
		CartesianCoordinate checkCoordinateC = new CartesianCoordinate(0.0, 0.0, 0.0);
		SphericCoordinate checkCoordinateS = new SphericCoordinate(0.0, 0.0, 0.0);
		Coordinate test1 = new CartesianCoordinate(0.0, 0.0, 0.0);
		Coordinate test2 = new SphericCoordinate(0.0, 0.0, 0.0);
		assertTrue(checkCoordinateC.isEqual(test1));
		assertTrue(checkCoordinateC.isEqual(test2));
		assertTrue(checkCoordinateS.isEqual(test1));
		assertTrue(checkCoordinateS.isEqual(test2));
		
		checkCoordinateC = new CartesianCoordinate(0.0, 0.0, 1.0);
		checkCoordinateS = new SphericCoordinate(0.0, 0.0, 1.0);
		Coordinate test3 = new SphericCoordinate(0.0, 0.0, 1.0);
		assertTrue(checkCoordinateC.isEqual(test3));
		assertTrue(checkCoordinateS.isEqual(test3));
	}
	
	@Test
	public void testAsSphericAndIsEqual() {
		SphericCoordinate checkCoordinate = new SphericCoordinate(0.0, 0.0, 0.0);
		Coordinate test1 = new CartesianCoordinate(0.0, 0.0, 0.0);
		Coordinate test2 = new SphericCoordinate(0.0, 0.0, 0.0);
		SphericCoordinate test1S = test1.asSphericCoordinate();
		assertTrue(checkCoordinate.isEqual(test1S));
		SphericCoordinate test2S = (SphericCoordinate) test2;
		assertTrue(checkCoordinate.isEqual(test2S));
		checkCoordinate = new SphericCoordinate(0.0, 0.0, 1.0);
		Coordinate test3 = new CartesianCoordinate(0.0, 0.0, 1.0);
		SphericCoordinate test3S = test3.asSphericCoordinate();
		assertTrue(checkCoordinate.isEqual(test3S));

	}
	
	@Test
	public void testGetCartesianDistance() {
		Coordinate sphericA = new SphericCoordinate(0.0, 0.0, 0.0);
		Coordinate sphericB = new SphericCoordinate(0.0, 0.0, 1.0);
		Coordinate cartesianA = new CartesianCoordinate(0.0, 0.0, 0.0);
		Coordinate cartesianB = new CartesianCoordinate(0.0, 0.0, 1.0);
		
		assertTrue(sphericA.getCartesianDistance(sphericA) == 0.0);
		assertTrue(sphericA.getCartesianDistance(sphericB) == 1.0);
		assertTrue(sphericA.getCartesianDistance(cartesianA) == 0.0);
		assertTrue(sphericA.getCartesianDistance(cartesianB) == 1.0);
		
		assertTrue(sphericB.getCartesianDistance(sphericB) == 0.0);
		assertTrue(sphericB.getCartesianDistance(cartesianA) == 1.0);
		assertTrue(sphericB.getCartesianDistance(cartesianB) == 0.0);
		
		assertTrue(cartesianA.getCartesianDistance(cartesianA) == 0.0);
		assertTrue(cartesianA.getCartesianDistance(cartesianB) == 1.0);
		
		assertTrue(cartesianB.getCartesianDistance(cartesianB) == 0.0);
		
	}
	
	@Test
	public void testGetCentralAngle() {
		Coordinate sphericA = new SphericCoordinate(0.0, 0.0, 0.0);
		Coordinate cartesianA = new CartesianCoordinate(0.0, 0.0, 0.0);
		
		assertTrue(sphericA.getCentralAngle(cartesianA) == 0);
		assertTrue(cartesianA.getCentralAngle(sphericA) == 0);
	}
	
}