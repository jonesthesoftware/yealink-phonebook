/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.github.jonesthesoftware.yealink.phonebook.jpa.type.DirectoryEntry;

@RepositoryRestResource( collectionResourceRel = "directoryEntry", path = "directoryEntry" )
public interface DirectoryEntryRepository extends JpaRepository<DirectoryEntry, Integer> {

	@Query( value = 
			"SELECT de FROM DirectoryEntry de"
			+ " WHERE LOWER( de.entryName ) LIKE LOWER( CONCAT( '%', :name, '%' ) )" 
	)
	List<DirectoryEntry> searchByEntryNameContains( @Param( "name" ) String name );
	
	@Query( value = 
			"SELECT de FROM DirectoryEntry de JOIN de.phoneEntries pe"
			+ " WHERE pe.phoneNumber = :phoneNumber" 
	)
	List<DirectoryEntry> findByPhoneNumber( @Param( "phoneNumber" ) String phoneNumber );

}
