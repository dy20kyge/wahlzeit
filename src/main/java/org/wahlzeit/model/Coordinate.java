
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
}