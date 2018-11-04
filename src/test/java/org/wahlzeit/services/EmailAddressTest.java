/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import org.junit.*;
import junit.framework.TestCase;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 *
	 */
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}
	
	//Works more or less, because invalids are allowed for local testing...
	public void testEmailAddressIsValid() {
		assertTrue(createEmailAddress("peter@maier.de").isValid());
		assertTrue(createEmailAddress("petermaier.de").isValid());
	}
	
	public void testAddressIsEmpty() {
		assertTrue(createEmailAddress("").isEmpty());
		assertFalse(createEmailAddress("peter@maier.de").isEmpty());
		assertFalse(createEmailAddress("petermaierde").isEmpty());
	}
	
	protected EmailAddress createEmailAddress(String s) {
		return EmailAddress.getFromString(s);
	}
	
	public void testIsEqual() {
		EmailAddress ea = createEmailAddress("hallo@adap.de");
		EmailAddress ea2 = createEmailAddress("hallo@adap.de");
		EmailAddress ea3 = createEmailAddress("hallo@bdap.de");
		assertTrue(ea.isEqual(ea));
		assertTrue(ea.isEqual(ea2));
		assertFalse(ea.isEqual(ea3));
		
		
	}

}

