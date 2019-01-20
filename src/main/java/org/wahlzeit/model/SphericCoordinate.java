package org.wahlzeit.model;

import java.util.logging.Logger;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.model.CartesianCoordinate;
import java.util.*;

@PatternInstance(
	 patternName = "ValueObject",
	 participants = { "SphericCoordinate"} 
)

public class SphericCoordinate extends AbstractCoordinate{
	
	//logger
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());
		
	//HashMap
	private static HashMap<Integer, SphericCoordinate> hm = new HashMap<Integer, SphericCoordinate>();
	
	protected double phi;
	protected double theta;
	protected double radius;
	
	/**
	 * @methodtype constructor
	 */
	private SphericCoordinate(double in_phi, double in_theta, double in_radius) {
		this.phi = in_phi;
		this.theta = in_theta;
		this.radius = in_radius;
		
		//class invariants
		assertClassInvariants();
		
	}
	
	/**
	 * @methodtype get
	 */
	public static SphericCoordinate createSphericCoordinate(double in_phi, double in_theta, double in_radius) throws IllegalArgumentException {
		//preconditions
		try {
			assertArgumentDoubleNotNull(in_phi);
			assertArgumentDoubleNotNull(in_theta);
			assertArgumentDoubleNotNull(in_radius);
		} catch (IllegalArgumentException e) {
			log.warning(LogBuilder.createSystemMessage().
					addException("Problem SphericCoordinate creation", e).toString());
			throw e;
		}
		
		String hashThis = "Hash" + in_phi + ":" + in_theta + ":" + in_radius + "!";
		int hashValue = hashThis.hashCode();
		if(hm.containsKey(hashValue)) {
			return hm.get(hashValue);
		}
		else {
			hm.put(hashValue, new SphericCoordinate(in_phi, in_theta, in_radius));
		}
		
		return hm.get(hashValue);
		
		
	}
	
	//Interface Methods
	/**
	 * @methodtype get
	 */
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = this.radius * Math.sin(Math.toRadians(this.theta)) * Math.cos(Math.toRadians(this.phi));
		double y = this.radius * Math.sin(Math.toRadians(this.theta)) * Math.sin(Math.toRadians(this.phi));
		double z = this.radius * Math.cos(Math.toRadians(this.theta));
		CartesianCoordinate result = null;
		try {
			result = CartesianCoordinate.createCartesianCoordinate(x, y, z);
		}
		catch(IllegalArgumentException e) {
			
		}
		return result;
	}
	
	
	/**
	 * @methodtype get
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/**
	 * @methodtype get
	 */
	@Override
	public boolean isEqual(Coordinate in_coor) throws IllegalArgumentException{
		//precondition
		super.assertArgumentCoordinateNotNull(in_coor);
		
		SphericCoordinate sc = in_coor.asSphericCoordinate();
		sc.assertClassInvariants();
		
		return this.isEqualSpheric(sc);
	}
	
	//Class methods
	/**
	 * @methodtype set
	 */
	public SphericCoordinate setPhi(double in_phi) {
		//precondition
		assertInRange(-180, 180, in_phi);
		
		return new SphericCoordinate(in_phi, this.getTheta(), this.getRadius());
	}
	
	/**
	 * @methodtype set
	 */
	public SphericCoordinate setTheta(double in_theta) {
		//precondition
		assertInRange(0, 180, in_theta);
		
		return new SphericCoordinate(this.getPhi(), in_theta, this.getRadius());
	
	}
	
	/**
	 * @methodtype set
	 */
	public SphericCoordinate setRadius(double in_radius) {
		//precondition
		assertMoreThan(0, in_radius);
		
		return new SphericCoordinate(this.getPhi(), this.getTheta(), in_radius);
	}
	
	/**
	 * @methodtype get
	 */
	public double getTheta() {
		return this.theta;
	}
	
	/**
	 * @methodtype get
	 */
	public double getPhi() {
		return this.phi;
	}
	
	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return this.radius;
	}
	
	/**
	 * @methodtype get
	 */
	public int hashCode() {
		String toHash = "Hash" + getTheta() + ":" + getPhi() + ":" + getRadius() + "!";
		return toHash.hashCode();
	}
	
	/**
	 * @methodtype get/helper
	 */
	private boolean isEqualSpheric(SphericCoordinate in_coor) {
		
		if(this.getRadius() == in_coor.getRadius() && this.getPhi() == in_coor.getPhi() && this.getTheta() == in_coor.getTheta()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertInRange(double min, double max, double val) {
		if(val < min) {
			throw new IllegalArgumentException("Value not in range");
		}
		if(val > max) {
			throw new IllegalArgumentException("Value not in range");
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertMoreThan(double min, double val) {
		if(val < min) {
			throw new IllegalArgumentException("Value to small");
		}
	}
	
	/**
	 * @methodtype assertion/invariant
	 */
	private void assertClassInvariants() {
		assertInRange(-180, 180, this.phi);
		assertInRange(0, 180, this.theta);
		assertMoreThan(0, this.radius);
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertSphericCoordinate(Coordinate c) {
		if(!(c instanceof SphericCoordinate)){
			throw new IllegalArgumentException("No CartesianCoordinate given!");
		}
	}
	
}