
package org.wahlzeit.model;

public interface Coordinate{
	
	/**
	 * @methodtype get Returns the Coordinate as CartesianCoordinate
	 */
	CartesianCoordinate asCartesianCoordinate();
	
	/**
	 * @methodtype get Returns the Coordinate as SphericCoordinate
	 */
	SphericCoordinate asSphericCoordinate();
	
	/**
	 * @methodtype get Returns the Cartesian Distance between two Coordinates
	 */
	double getCartesianDistance(Coordinate c) throws IllegalArgumentException;
	
	/**
	 * @methodtype get Returns the central angle between two coordinates
	 */
	double getCentralAngle(Coordinate c) throws IllegalArgumentException;
	
	/**
	 * @methodtype get Returns a boolean value regarding the equality of the coordinates
	 */
	boolean isEqual(Coordinate c) throws IllegalArgumentException; 
	
}