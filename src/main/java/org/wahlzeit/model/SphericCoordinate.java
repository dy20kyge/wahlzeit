package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{
	
	protected double phi;
	protected double theta;
	protected double radius;
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate() {
		this.phi = 0.0;
		this.theta = 0.0;
		this.radius = 0.0;
		
	}
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double in_phi, double in_theta, double in_radius) {
		//preconditions
		super.assertArgumentDoubleNotNull(in_phi);
		super.assertArgumentDoubleNotNull(in_theta);
		super.assertArgumentDoubleNotNull(in_radius);
		
		//class invariants
		assertClassInvariants();
		
		this.setPhi(in_phi);
		this.setTheta(in_theta);
		this.setRadius(in_radius);
		
		//class invariants
		assertClassInvariants();
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
		return new CartesianCoordinate(x, y, z);
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
	public boolean isEqual(Coordinate in_coor) throws IllegalArgumentEyception{
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
	public void setPhi(double in_phi) {
		//precondition
		assertInRange(-180, 180, in_phi);
		this.phi = in_phi;
	}
	
	/**
	 * @methodtype set
	 */
	public void setTheta(double in_theta) {
		//precondition
		assertInRange(0, 180, in_theta);
		if(0.0 <= in_theta || 0.0 >= in_theta) {
			//wenn man das weg laesst oder if(true) schreibt failen die tests...
		
			this.theta = in_theta;
		}
	
	}
	
	/**
	 * @methodtype set
	 */
	public void setRadius(double in_radius) {
		//precondition
		assertMoreThan(0, in_radius);
		
		this.radius = in_radius;
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