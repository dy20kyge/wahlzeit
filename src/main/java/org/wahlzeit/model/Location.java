
package org.wahlzeit.model;

public class Location{
	
	protected Coordinate coordinate;
	
	private Location(){
		
	}
	
	public Location(Coordinate c) throws IllegalArgumentException {
		this.setCoordinate(c);
	}
	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate c) throws IllegalArgumentException {
		//precondition
		assertArgumentNotNull(c);
		
		this.coordinate = c;
	}
	
	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public boolean equals(Location loc) throws IllegalArgumentException {
		return this.coordinate.isEqual(loc.coordinate);
	}
	
	private void assertArgumentNotNull(Object o) {
		if(o == null) {
			throw new IllegalArgumentException("No argument provided!");
		}
	}
	
}