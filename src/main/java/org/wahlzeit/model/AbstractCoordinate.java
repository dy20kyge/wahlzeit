package org.wahlzeit.model;


public abstract class AbstractCoordinate implements Coordinate{
	
	/**
	 * @methodtype get
	 */
	@Override
	public double getCartesianDistance(Coordinate in_coor) throws IllegalArgumentException{
		//preconditions
		assertArgumentCoordinateNotNull(in_coor);

		
		CartesianCoordinate cc = this.asCartesianCoordinate();
			return cc.getDistanceCartesian(in_coor.asCartesianCoordinate());		
	}
	
	/**
	 * @methodtype get
	 */
	@Override
	public double getCentralAngle(Coordinate in_coor) throws IllegalArgumentException{
		//preconditions
		assertArgumentCoordinateNotNull(in_coor);
		
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
	
	/**
	 * @methodtype assertion
	 */
	protected void assertArgumentCoordinateNotNull(Coordinate c) throws IllegalArgumentException{
		if(c == null){
			throw new IllegalArgumentException("No Coordinate given!");
		}
	}
	
	protected void assertArgumentDoubleNotNull(Double d) throws IllegalArgumentException{
		if(d == null){
			throw new IllegalArgumentException("No Double Value given!");
		}
	}
	
	protected void assertArgumentNotNull(Object o) {
		if(o == null) {
			throw new IllegalArgumentException("No argument provided!");
		}
	}
	
	
	
	
	
}