package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
	
	protected double phi;
	protected double theta;
	protected double radius;
	
	public SphericCoordinate() {
		this.phi = 0.0;
		this.theta = 0.0;
		this.radius = 0.0;
		
	}
	
	public SphericCoordinate(double in_phi, double in_theta, double in_radius) {
		this.setPhi(in_phi);
		this.setTheta(in_theta);
		this.setRadius(in_radius);
	}
	
	//Interface Methods
	/**
	 * @methodtype get
	 */
	public CartesianCoordinate asCartesianCoordinate() {
		double x = this.radius * Math.sin(Math.toRadians(this.theta)) * Math.cos(Math.toRadians(this.phi));
		double y = this.radius * Math.sin(Math.toRadians(this.theta)) * Math.sin(Math.toRadians(this.phi));
		double z = this.radius * Math.cos(Math.toRadians(this.theta));
		return new CartesianCoordinate(x, y, z);
	}
	/**
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		CartesianCoordinate cc = this.asCartesianCoordinate();
			return cc.getCartesianDistance(in_coor.asCartesianCoordinate());		
	}
	
	/**
	 * @methodtype get
	 */
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/**
	 * @methodtype get
	 */
	public double getCentralAngle(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		SphericCoordinate sc = in_coor.asSphericCoordinate();
		if(this.radius != sc.radius) {
			return 0;
		}
		
		double alpha_t = Math.cos(Math.toRadians(this.phi));
		double alpha_o = Math.cos(Math.toRadians(sc.phi));
		
		double beta_t = Math.toRadians(this.theta);
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
		return this.isEqualSpheric(in_coor.asSphericCoordinate());
	}
	
	//Class methods
	public void setPhi(double in_phi) {
		if(in_phi >= -180 && in_phi <= 180) {
			this.phi = in_phi;
		}
		else {
			this.phi = 0.0;
		}
	}
	
	public void setTheta(double in_theta) {
		if(in_theta >= 0 && in_theta <= 180) {
			this.theta = in_theta;
		}
		else {
			this.theta = 0.0;
		}
	}
	
	public void setRadius(double in_radius) {
		if(in_radius > 0) {
			this.radius = in_radius;
		}
		else {
			this.radius = 0.0;
		}
	}
	
	public double getTheta() {
		return this.theta;
	}
	
	public double getPhi() {
		return this.phi;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public boolean isEqualSpheric(SphericCoordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		if(this.getRadius() == in_coor.getRadius() && this.getPhi() == in_coor.getPhi() && this.getTheta() == in_coor.getTheta()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}