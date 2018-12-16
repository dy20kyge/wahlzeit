
package org.wahlzeit.model;

import java.util.logging.Logger;
import org.wahlzeit.services.LogBuilder;


public class CartesianCoordinate extends AbstractCoordinate{
	
	//logger
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());	
	
	/**
	 * Coordinate in cartesian coordinates
	 */
	protected final double x;
	protected final double y;
	protected final double z;

	public CartesianCoordinate() {
		this.x = 0;
		this.y = 0;
		this.z = 0;	
	}
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double xVal, double yVal, double zVal) throws IllegalArgumentException{
		//precondition check and logging
		try {
			assertArgumentNotNull(xVal);
			assertArgumentNotNull(yVal);
			assertArgumentNotNull(zVal);
		} catch (IllegalArgumentException e) {
			log.warning(LogBuilder.createSystemMessage().
					addException("Problem CartesianCoordinate creation", e).toString());
			throw e;
		}
		this.x = xVal;
		this.y = yVal;
		this.z = zVal;
	}
	
	//Methods for the interface
	/**
	 * @methodtype get
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	/**
	 * @methodtype get
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
		double theta;
		double phi;
		if(radius == 0.0) {
			theta = 0.0;
			phi = 0.0;
		} else {
			theta = Math.acos(this.z/radius);
			phi = Math.atan2(this.y, this.x);
		}
		return new SphericCoordinate(phi, theta, radius);
	}
	
	/**
	 * @methodtype get
	 */
	@Override
	public boolean isEqual(Coordinate in_coor) throws IllegalArgumentException{
		//preconditions
		super.assertArgumentCoordinateNotNull(in_coor);
		
		return this.isEqualCartesian(in_coor.asCartesianCoordinate());
	}
	
	//Class Methods
	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setX(double xValue) throws IllegalArgumentException {
		//preconditions
		super.assertArgumentNotNull(xValue);
		
		return new CartesianCoordinate(xValue, this.getY(), this.getZ());
		
	}
	
	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setY(double yValue) throws IllegalArgumentException {
		//preconditions
		super.assertArgumentNotNull(yValue);
		
		return new CartesianCoordinate(this.getX(), yValue, this.getZ());
	}
	
	/**
	 * @methodtype set
	 */
	public CartesianCoordinate setZ(double zValue) throws IllegalArgumentException {
		//preconditions
		super.assertArgumentNotNull(zValue);
		
		return new CartesianCoordinate(this.getX(), this.getY(), zValue);
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
	private boolean isEqualCartesian(CartesianCoordinate compCoordinate) throws IllegalArgumentException{
		//preconditions
		//assertCartesianCoordinate(compCoordinate);
		
		return (this.getX() == compCoordinate.getX() && this.getY() == compCoordinate.getY() && this.getZ() == compCoordinate.getZ());
	}
	
	public boolean equals(Coordinate c) {
		super.assertArgumentCoordinateNotNull(c);
		
		return this.isEqual(c);
	}
	/**
	 * TODO check null values before methond, check overflows
	 */
	
	protected double getDistanceCartesian(CartesianCoordinate distCoordinate){
		double xDist = (this.getX() - distCoordinate.getX())*(this.getX() - distCoordinate.getX());
		double yDist = (this.getY() - distCoordinate.getY())*(this.getY() - distCoordinate.getY());
		double zDist = (this.getZ() - distCoordinate.getZ())*(this.getZ() - distCoordinate.getZ());
		return Math.sqrt(xDist + yDist + zDist);
	}
	
	protected void assertCartesianCoordinate(Coordinate c){
		if(!(c instanceof CartesianCoordinate)){
			throw new IllegalArgumentException("No CartesianCoordinate given!");
		}
	}
}