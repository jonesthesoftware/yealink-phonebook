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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This is a type which is used to represent an entry in the Yealink Phone Directory
 *  
 * @author Wayne Jones
 *
 */
@Entity
@Table( name = "DIRECTORY_ENTRY" )
public class DirectoryEntry {
	
	@Id
	@Column( name = "DIRECTORY_ENTRY_ID" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "DIRECTORY_ENTRY_SEQ" )
	@SequenceGenerator( name = "DIRECTORY_ENTRY_SEQ", sequenceName = "DIRECTORY_ENTRY_SEQ" )
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "DIRECTORY_ID", nullable = false )
	private Directory directory;
	
	private String entryName;
	
	@OneToMany( mappedBy = "directoryEntry" )
	private Collection<PhoneEntry> phoneEntries;
	
	public void setEntryName( String entryName ) {
		this.entryName = entryName;
	}
	
	public String getEntryName() {
		return entryName;
	}
	
	public Collection<PhoneEntry> getPhoneEntries() {
		if ( phoneEntries == null ) {
			phoneEntries = new ArrayList<PhoneEntry>();
		}
		return phoneEntries;
	}
	
}
