/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class PhoneBookWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure( HttpSecurity httpSecurity ) throws Exception {
		// TODO: Work out security strategy for endpoints
		httpSecurity.authorizeRequests().antMatchers( "/" ).permitAll();
	}
	
}
