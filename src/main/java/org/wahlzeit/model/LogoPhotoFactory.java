
package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import java.util.logging.Logger;

public class LogoPhotoFactory extends PhotoFactory {
	
	private static LogoPhotoFactory instance = null;
	
	/**
	 * @methodtype constructor
	 */
	protected LogoPhotoFactory() {
		super();
	}
	
	/*
	 * Acccess method for singleton
	 */
	/**
	 * @methodtype get
	 */
	public static synchronized LogoPhotoFactory getInstance() {
		if(instance == null) {
			setInstance(new LogoPhotoFactory());
		}
		
		return instance;
	}
	
	/**
	 * @methodtype set
	 */
	protected static synchronized void setInstance(LogoPhotoFactory lpf) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = lpf;
	}
	
	/**
	 * @methodtype factory
	 */
	@Override
	public LogoPhoto createPhoto() {
		return new LogoPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public LogoPhoto createPhoto(PhotoId id) {
		return (LogoPhoto) new Photo(id);
	}
	
	@Override
	public LogoPhoto loadPhoto(PhotoId id) {
		return null;
	}

}