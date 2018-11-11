
package org.wahlzeit.model;

import com.google.appengine.api.images.Image;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;
import org.wahlzeit.model.persistence.ImageStorage;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class LogoPhotoManager extends PhotoManager{
	
	protected static final PhotoManager instance = new LogoPhotoManager();
	
	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());
	
	protected Map<PhotoId, LogoPhoto> photoCache = new HashMap<PhotoId, LogoPhoto>();
	
	public LogoPhotoManager() {
		photoTagCollector = LogoPhotoFactory.getInstance().createPhotoTagCollector();
	}

	/**
	 *
	 */
	@Override
	public void savePhoto(Photo photo) {
		photo = (LogoPhoto) photo;
		updateObject(photo);
	}
	
	@Override
	protected void updateDependents(Persistent obj) {
		if (obj instanceof LogoPhoto) {
			LogoPhoto photo = (LogoPhoto) obj;
			saveScaledImages(photo);
			updateTags(photo);
			UserManager userManager = UserManager.getInstance();
			Client owner = userManager.getClientById(photo.getOwnerId());
			userManager.saveClient(owner);
		}
	}
	
	/**
	 * @methodtype command
	 *
	 * Persists all available sizes of the Photo. If one size exceeds the limit of the persistence layer, e.g. > 1MB for
	 * the Datastore, it is simply not persisted.
	 */
	@Override
	protected void saveScaledImages(Photo photo) {
		photo = (LogoPhoto) photo;
		String photoIdAsString = photo.getId().asString();
		ImageStorage imageStorage = ImageStorage.getInstance();
		PhotoSize photoSize;
		int it = 0;
		boolean moreSizesExist = true;
		do{
			photoSize = PhotoSize.values()[it];
			it++;
			Image image = photo.getImage(photoSize);
			if (image != null) {
				try {
					if (!imageStorage.doesImageExist(photoIdAsString, photoSize.asInt())) {
						imageStorage.writeImage(image, photoIdAsString, photoSize.asInt());
					}
				} catch (Exception e) {
					log.warning(LogBuilder.createSystemMessage().
							addException("Problem when storing image", e).toString());
					moreSizesExist = false;
				}
			} else {
				log.config(LogBuilder.createSystemMessage().
						addParameter("No image for size", photoSize.asString()).toString());
				moreSizesExist = false;
			}
		} while (it < PhotoSize.values().length && moreSizesExist);
	}
	
	/**
	 * Removes all tags of the Photo (obj) in the datastore that have been removed by the user and adds all new tags of
	 * the photo to the datastore.
	 */
	@Override
	protected void updateTags(Photo photo) {
		photo = (LogoPhoto) photo;
		// delete all existing tags, for the case that some have been removed
		deleteObjects(Tag.class, Tag.PHOTO_ID, photo.getId().asString());

		// add all current tags to the datastore
		Set<String> tags = new HashSet<String>();
		photoTagCollector.collect(tags, photo);
		for (Iterator<String> i = tags.iterator(); i.hasNext(); ) {
			Tag tag = new Tag(i.next(), photo.getId().asString());
			log.config(LogBuilder.createSystemMessage().addParameter("Writing Tag", tag.asString()).toString());
			writeObject(tag);
		}
	}
	

	/**
	 *
	 */
	public LogoPhoto getVisiblePhoto(PhotoFilter filter) {
		filter.generateDisplayablePhotoIds();
		return (logoPhoto) getPhotoFromId(filter.getRandomDisplayablePhotoId());
	}

	/**
	 *
	 */
	public LogoPhoto createPhoto(String filename, Image uploadedImage) throws Exception {
		PhotoId id = PhotoId.getNextId();
		Photo result = PhotoUtil.createPhoto(filename, id, uploadedImage);
		addPhoto(result);
		return (LogoPhoto) result;
	}

	/**
	 * @methodtype command
	 */
	public void addPhoto(LogoPhoto photo) throws IOException {
		PhotoId id = photo.getId();
		assertIsNewPhoto(id);
		doAddPhoto(photo);

		GlobalsManager.getInstance().saveGlobals();
	}
	
}