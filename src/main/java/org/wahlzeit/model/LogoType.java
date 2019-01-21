package org.wahlzeit.model;

import java.util.*;

public class LogoType {
	
	protected LogoType superType = null;
	protected Set<LogoType> subTypes = new HashSet<LogoType>();
	
	/*
	 * the name of the team
	 */
	public String name;
	
	public LogoType(String inName) {
		this.name = inName;
	}
	
	public LogoType getSuperType() {
		return superType;
	}
	
	public Iterator<LogoType> getSubtypeIterator(){
		return subTypes.iterator();
	}
	
	public void addSubType(LogoType lt) {
		 assert (lt != null) : "tried to set null sub-type";
		 lt.setSuperType(this);
		 subTypes.add(lt);
	}
	
	public boolean hasInstance(Logo inLogo) {
		 assert (inLogo != null) : "asked about null object";
		 if (inLogo.getType() == this) {
			 return true;
		 }
		 for (LogoType type : subTypes) {
			 if (type.hasInstance(inLogo)) {
				 	return true;
			 }
		 }
		 return false;
	} 

	
	/**
	 * @methodtype constructor
	 */
	public Logo createInstance() {
		return new Logo(this);
	}
	
	/**
	 * @methodtype set
	 */
	public void setName(String inName) throws IllegalArgumentException {
		assertArgumentNotNull(inName);
		this.name = inName;
	}
	
	/**
	 * @methodtype set
	 */
	public void setSuperType(LogoType lt) {
		this.superType = lt;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @methodtype assertion
	 */
	private void assertArgumentNotNull(Object o) {
		if(o == null) {
			throw new IllegalArgumentException("No argument provided!");
		}
	}
	
}