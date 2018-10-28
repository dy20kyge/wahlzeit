package org.wahlzeit.model;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationTest{
	
	@Test
	public void testSetAndGet() {
		Location loc = new Location();
		Coordinate c = new Coordinate(0, 0, 1);
		loc.setCoordinate(c);
		Coordinate check = loc.getCoordinate();
		assertEquals(check, c);
	}
	
	@Test
	public void testEquals() {
		Coordinate c0 = new Coordinate(0, 0, 1);
		Coordinate c1 = new Coordinate(0, 0, 1);
		assertTrue(c0.isEqual(c1));
	}
	
}