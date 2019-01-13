
package org.wahlzeit.model;

import java.util.logging.Logger;
import org.wahlzeit.services.LogBuilder;
import java.util.*;
import org.wahlzeit.model.SphericCoordinate;


public class CartesianCoordinate extends AbstractCoordinate{
	
	//logger
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());	
	
	//HashMap
	private static HashMap<Integer, CartesianCoordinate> hm = new HashMap<Integer, CartesianCoordinate>();
	/**
	 * Coordinate in cartesian coordinates
	 */
	protected final double x;
	protected final double y;
	protected final double z;

	private CartesianCoordinate(double xVal, double yVal, double zVal) {
		this.x = xVal;
		this.y = yVal;
		this.z = zVal;	
	}
	
	/**
	 * @methodtype constructor
	 */
	public static CartesianCoordinate createCartesianCoordinate(double xVal, double yVal, double zVal) throws IllegalArgumentException{
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
		
		String hashThis = "Hash" + xVal + ":" + yVal + ":" + zVal + "!";
		int hashValue = hashThis.hashCode();
		if(hm.containsKey(hashValue)) {
			return hm.get(hashValue);
		}
		else {
			hm.put(hashValue, new CartesianCoordinate(xVal, yVal, zVal));
		}
		
		return hm.get(hashValue);
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
		return SphericCoordinate.createSphericCoordinate(phi, theta, radius);
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
	
	/**
	 * @methodtype get
	 */
	public boolean equals(Object c){
		if( (c == null) || !(c instanceof CartesianCoordinate)) {
			return false;
		}
		
		return this.isEqual((CartesianCoordinate) c);
	}
	
	/**
	 * @methodtype get
	 */
	public int hashCode() {
		String toHash = "Hash" + getX() + ":" + getY() + ":" + getZ() + "!";
		return toHash.hashCode();
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