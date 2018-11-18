
package org.wahlzeit.model;

public class Location{
	
	protected Coordinate coordinate;
	
	public Location(){
		
	}
	
	public Location(Coordinate c) {
		this.coordinate = c;
	}
	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate c) {
		this.coordinate = c;
	}
	
	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public boolean equals(Location loc) {
		return this.coordinate.isEqual(loc.coordinate);
	}
	
}