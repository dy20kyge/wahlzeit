package org.wahlzeit.model;

import java.util.*;

public class LogoManager {
	
	private static HashMap<Integer, Logo> logoMap = new HashMap<Integer, Logo>();
	private static HashMap<String, LogoType> logoTypeMap = new HashMap<String, LogoType>();
	
	public Logo createLogo(String typeName) {
		 assertIsValidLogoTypeName(typeName);
		 LogoType lt = getLogoType(typeName);
		 Logo result = lt.createInstance();
		 logoMap.put(result.hashCode(), result);
		 return result;
		}
	
	public LogoType getLogoType(String inName) {
		if(logoTypeMap.containsKey(inName)) {
			return logoTypeMap.get(inName);
		} else {
			LogoType res = new LogoType(inName);
			logoTypeMap.put(inName, res);
			return res;
		}
	}
	
	private void assertIsValidLogoTypeName(String name) {
		if(name.length() > 0) {
			return;
		}
		else {
			throw new IllegalArgumentException("Empty name is not allowed!");
		}
	}

}