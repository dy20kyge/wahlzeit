package org.wahlzeit.model;


public abstract class AbstractCoordinate implements Coordinate{
	
	/**
	 * @methodtype get
	 */
	public double getCartesianDistance(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		CartesianCoordinate cc = this.asCartesianCoordinate();
			return cc.getDistanceCartesian(in_coor.asCartesianCoordinate());		
	}
	
	/**
	 * @methodtype get
	 */
	public double getCentralAngle(Coordinate in_coor) {
		if(in_coor == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
		SphericCoordinate tc = this.asSphericCoordinate();
		SphericCoordinate sc = in_coor.asSphericCoordinate();
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
	
	
}