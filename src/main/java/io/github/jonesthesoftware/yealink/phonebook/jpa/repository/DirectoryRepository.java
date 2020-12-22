/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.github.jonesthesoftware.yealink.phonebook.jpa.type.Directory;

@RepositoryRestResource( collectionResourceRel = "directory", path = "directory")
public interface DirectoryRepository extends JpaRepository<Directory, Short> {
	
	List<Directory> findAllByDirectoryNameIgnoreCase( String directoryName );
	
}
