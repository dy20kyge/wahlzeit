package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest{
	
	@Test
	public void testSetAndGetCartesian() {
		Location loc = new Location();
		CartesianCoordinate c = new CartesianCoordinate(0, 0, 1);
		loc.setCoordinate(c);
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
	public void asCartesianTest() {
		CartesianCoordinate checkCoordinate = new CartesianCoordinate(1.0, 0.0, 0.0);
		Coordinate test1 = new CartesianCoordinate(1.0, 0.0, 0.0);
		Coordinate test2 = new SphericCoordinate(0.0, 0.0, 1.0);
		assertTrue(checkCoordinate.isEqual(test1));
		assertTrue(checkCoordinate.isEqual(test2));
	}
	
}