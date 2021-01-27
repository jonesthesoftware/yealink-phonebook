/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.jonesthesoftware.yealink.phonebook.jpa.service.PhoneBookService;
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.DirectoryEntry;

@Controller
public class PhoneEntryController {
	
	private final PhoneBookService phoneBookService;
	
	@Inject
	PhoneEntryController( PhoneBookService phoneBookService ) {
		this.phoneBookService = phoneBookService;
	}
	
	@RequestMapping( value = "/entry", method = RequestMethod.GET )
	public String viewEntry( 
			@RequestParam( "id" ) Integer id,
			Model model  
	) {
		DirectoryEntry directoryEntry = phoneBookService.getDirectoryEntry( id );
		
		model.addAttribute( "directoryEntry", directoryEntry );

		return "entry/view";
	}

}
