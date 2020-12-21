/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * This is a type which is used to represent a phone number entry in the Yealink Phone Directory
 *  
 * @author Wayne Jones
 *
 */
@Entity
@Table( name = "PHONE_ENTRY" )
public class PhoneEntry {
	@Id
	@Column( name = "PHONE_ENTRY_ID" )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PHONE_ENTRY_SEQ" )
	@SequenceGenerator( name = "PHONE_ENTRY_SEQ", sequenceName = "PHONE_ENTRY_SEQ" )
	private Integer id;
	
	@ManyToOne
	@JoinColumn( name = "DIRECTORY_ENTRY_ID", nullable = false )
	private DirectoryEntry directoryEntry;
	
	private String phoneNumber;
	
	public void setPhoneNumber( String phoneNumber ) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

}
