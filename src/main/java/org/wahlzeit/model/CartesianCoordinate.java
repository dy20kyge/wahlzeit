
package org.wahlzeit.model;


public class CartesianCoordinate extends AbstractCoordinate{
	
	/**
	 * Coordinate in cartesian coordinates
	 */
	protected double x;
	protected double y;
	protected double z;

	public CartesianCoordinate() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		
		
	}
	public CartesianCoordinate(double xVal, double yVal, double zVal) {
		this.x = xVal;
		this.y = yVal;
		this.z = zVal;
	}
	
	//Methods for the interface
	/**
	 * @methodtype get
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	/**
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
			return getDistanceCartesian(in_coor.asCartesianCoordinate());		
	}
	
	/**
	 * @methodtype get
	 */
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
		double theta = Math.acos(this.z/radius);
		double phi = Math.atan2(this.y, this.x);
		return new SphericCoordinate(phi, theta, radius);
	}
	
	/**
	 * @methodtype get
	 */
	public double getCentralAngle(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		SphericCoordinate sc = in_coor.asSphericCoordinate();
		SphericCoordinate tc = this.asSphericCoordinate();
		if(tc.radius != sc.radius) {
			return 0;
		}
		
		double alpha_t = Math.cos(Math.toRadians(tc.phi));
		double alpha_o = Math.cos(Math.toRadians(sc.phi));
		
		double beta_t = Math.toRadians(tc.theta);
		double beta_o = Math.toRadians(sc.theta);
		
		return Math.acos((Math.cos(beta_t) * Math.cos(beta_o) * Math.cos(alpha_t - alpha_o))
				+ (Math.sin(beta_t) * Math.sin(beta_o)));
		
	}
	/**
	 * @methodtype get
	 */
	public boolean isEqual(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		return this.isEqualCartesian(in_coor.asCartesianCoordinate());
	}
	
	
	
	//Class Methods
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
	
	/**
	 * TODO check double values
	 */
	public boolean isEqualCartesian(CartesianCoordinate compCoordinate) {
		if(compCoordinate == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		return this.getX() == compCoordinate.getX() && this.getY() == compCoordinate.getY() && this.getZ() == compCoordinate.getZ();
	}
	
	public boolean equals(Coordinate c) {
		if(c == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		return this.isEqual(c);
	}
	/**
	 * TODO check null values before methond, check overflows
	 */
	public double getDistanceCartesian(CartesianCoordinate distCoordinate) {
		double xDist = (this.getX() - distCoordinate.getX())*(this.getX() - distCoordinate.getX());
		double yDist = (this.getY() - distCoordinate.getY())*(this.getY() - distCoordinate.getY());
		double zDist = (this.getZ() - distCoordinate.getZ())*(this.getZ() - distCoordinate.getZ());
		return Math.sqrt(xDist + yDist + zDist);
	}
}