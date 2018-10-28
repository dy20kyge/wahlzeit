
package org.wahlzeit.model;



public class Coordinate{
	
	/**
	 * Coordinate in cartesian coordinates
	 */
	protected double x;
	protected double y;
	protected double z;

	
	
	/**
	 * @methodtype set
	 */
	public void setX(double xValue) {
		this.x = xValue;
	}
	
	/**
	 * @methodtype set
	 */
	public void setY(double yValue) {
		this.y = yValue;
	}
	
	/**
	 * @methodtype set
	 */
	public void setZ(double zValue) {
		this.z = zValue;
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * @methodtype get
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * @methodtype get
	 */
	public double getZ() {
		return this.z;
	}
	
	public boolean isEqual(Coordinate compCoordinate) {
		return this.x == compCoordinate.x && this.y == compCoordinate.y && this.z == compCoordinate.z;
	}
	
	public double getDistance(Coordinate distCoordinate) {
		double xDist = (this.x - distCoordinate.x)*(this.x - distCoordinate.x);
		double yDist = (this.y - distCoordinate.y)*(this.y - distCoordinate.y);
		double zDist = (this.z - distCoordinate.z)*(this.z - distCoordinate.z);
		return math.sqrt(xDist + yDist + zDist);
	}
}