/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.type;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This is a type which is used to represent the Yealink Phone Directory
 *  
 * @author Wayne Jones
 *
 */
@Entity
@Table( name = "DIRECTORY" )
public class Directory {

	@Id
	@Column( name="DIRECTORY_ID" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "DIRECTORY_SEQ" )
	@SequenceGenerator( name = "DIRECTORY_SEQ", sequenceName = "DIRECTORY_SEQ" )
	private Short id;
	
	private String directoryName;
	
	@OneToMany( mappedBy = "directory" )
	private Collection<DirectoryEntry> directoryEntries;
	
	public void setDirectoryName( String directoryName ) {
		this.directoryName = directoryName;
	}
	
	public String getDirectoryName() {
		return directoryName;
	}
	
	public Collection<DirectoryEntry> getDirectoryEntries() {
		if ( directoryEntries == null ) {
			directoryEntries = new ArrayList<DirectoryEntry>();
		}
		return directoryEntries;
	}	
	
}
