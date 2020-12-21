/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import io.github.jonesthesoftware.yealink.phonebook.jpa.repository.PhoneBookRepository;

@Service
public class PhoneBookService {
	
	@Inject
	private PhoneBookRepository phoneBookRepository;
	

}
