
package org.wahlzeit.model;

public interface Coordinate{
	
	public CartesianCoordinate asCartesianCoordinate();
	public double getCartesianDistance(Coordinate);
	public SphericCoordinate asSphericCoordinate();
	public double getCentralAngle(Coordinate);
	public boolean isEqual(Coordinate); 
	
}