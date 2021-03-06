/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.jonesthesoftware.yealink.phonebook.jpa.service.PhoneBookService;
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.Directory;

@Controller
public class PhoneBookController {
	
	private final PhoneBookService phoneBookService;
	
	@Inject
	PhoneBookController( PhoneBookService phoneBookService ) {
		this.phoneBookService = phoneBookService;
	}
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String listDirectories( Model model ) {
		List<Directory> directories = phoneBookService.getDirectories();

		model.addAttribute( "directories", directories );

		return "index";
	}


}
