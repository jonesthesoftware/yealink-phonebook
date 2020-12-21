/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RestController;

import io.github.jonesthesoftware.yealink.phonebook.jpa.service.PhoneBookService;

@RestController
public class PhoneBookController {
	
	private final PhoneBookService phoneBookService;
	
	@Inject
	PhoneBookController( PhoneBookService phoneBookService ) {
		this.phoneBookService = phoneBookService;
	}

}
