/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.type;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This is a type which is used to represent an entry in the Yealink Phone Directory
 *  
 * @author Wayne Jones
 *
 */
public class DirectoryEntry {
	
	private String name;
	private Collection<String> telephone;
	
	public DirectoryEntry( String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
		
	public Collection<String> getTelephone() {
		if ( telephone == null ) {
			telephone = new ArrayList<String>();
		}
		return telephone;
	}
	
}
