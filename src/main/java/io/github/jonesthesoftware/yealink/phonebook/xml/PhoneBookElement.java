/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.xml;

/**
 * Phone Book Element XML constants
 * 
 * @author Wayne Jones
 *
 */
public class PhoneBookElement {
	
	private PhoneBookElement() {}

	/**
	 * Postfix used for the Phone Book Directory (Root Element)
	 * The Yealink Phonebook is not a true XML document, it uses this postfix to identify the root element
	 */
	public static final String DIRECTORY_POSTFIX = "IPPhoneDirectory";
	
	/**
	 * The name of an element used for a Phone Book Directory Entry
	 */
	public static final String DIRECTORY_ENTRY = "DirectoryEntry";
	
	/**
	 * The name of an element used for a Contact Name
	 */
	public static final String CONTACT_NAME = "Name";
	
	/**
	 * The name of an element used for a Telephone
	 */
	public static final String PHONE_NUMBER = "Telephone";
	
}
