/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.type;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This is a type which is used to represent the Yealink Phone Directory
 *  
 * @author Wayne Jones
 *
 */
public class Directory {

	private String name;
	private Collection<DirectoryEntry> directoryEntries;

	public Directory( String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Collection<DirectoryEntry> getDirectoryEntries() {
		if ( directoryEntries == null ) {
			directoryEntries = new ArrayList<DirectoryEntry>();
		}
		return directoryEntries;
	}	
	
}
