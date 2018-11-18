package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest{
	
	@Test
	public void testSetAndGet() {
		Location loc = new Location();
		CartesianCoordinate c = new CartesianCoordinate(0, 0, 1);
		loc.setCoordinate(c);
		CartesianCoordinate check = loc.getCoordinate();
		assertEquals(check, c);
	}
	
	@Test
	public void testEquals() {
		CartesianCoordinate c0 = new CartesianCoordinate(0, 0, 1);
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 1);
		assertTrue(c0.isEqual(c1));
	}
	
	@Test
	public void testDistance() {
		CartesianCoordinate c0 = new CartesianCoordinate(0, 0, 1);
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		assertTrue(c0.getDistance(c1) == 1.0);
	}
	
	@Test
	public void testDistance2() {
		CartesianCoordinate c0 = new CartesianCoordinate(2, 2, 1);
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		assertTrue(c0.getDistance(c1) ==3.0);
	}
	
}