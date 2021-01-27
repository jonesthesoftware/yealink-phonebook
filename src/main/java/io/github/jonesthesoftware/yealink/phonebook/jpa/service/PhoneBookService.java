/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import io.github.jonesthesoftware.yealink.phonebook.jpa.repository.DirectoryEntryRepository;
import io.github.jonesthesoftware.yealink.phonebook.jpa.repository.DirectoryRepository;
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.Directory;
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.DirectoryEntry;

@Service
public class PhoneBookService {
	
	@Inject
	private DirectoryRepository directoryRepository;
	
	@Inject
	private DirectoryEntryRepository directoryEntryRepository;
	
	public List<Directory> getDirectories() {
		return directoryRepository.findAll();
	}
	
	public Directory getDirectory( Short id ) {
		return directoryRepository.getOne( id );
	}
	
	public DirectoryEntry getDirectoryEntry( Integer id ) {
		return directoryEntryRepository.getOne( id );
	}

}
