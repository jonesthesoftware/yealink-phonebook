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
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.Directory;

@Controller
public class PhoneDirectoryController {
	
	private final PhoneBookService phoneBookService;
	
	@Inject
	PhoneDirectoryController( PhoneBookService phoneBookService ) {
		this.phoneBookService = phoneBookService;
	}
	
	@RequestMapping( value = "/directory", method = RequestMethod.GET )
	public String viewDirectory( 
			@RequestParam( "id" ) Short id,
			Model model  
	) {
		Directory directory = phoneBookService.getDirectory( id );
		
		model.addAttribute( "directory", directory );

		return "directory/view";
	}

}
