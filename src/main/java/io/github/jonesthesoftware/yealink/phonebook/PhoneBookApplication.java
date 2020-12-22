/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( "io.github.jonesthesoftware.yealink.phonebook.jpa.repository" )
@EntityScan( "io.github.jonesthesoftware.yealink.phonebook.jpa.type" )
public class PhoneBookApplication {

	public static void main( String[] args ) {
		SpringApplication.run( PhoneBookApplication.class, args );
	}
	
}
