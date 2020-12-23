/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.type;

import java.util.Arrays;

public enum PhoneTypeEnum {
	LANDLINE("L"),
	MOBILE("M"),
	OTHER("O");
	
	private String code;
	
	private PhoneTypeEnum( String code ) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static PhoneTypeEnum of( String code ) {
		if ( code == null ) {
			return null;
		}
		return Arrays.stream( PhoneTypeEnum.values() )
		          .filter( pt -> pt.getCode().equals( code ) )
		          .findFirst()
		          .orElseThrow( IllegalArgumentException::new );
	}
	
}
