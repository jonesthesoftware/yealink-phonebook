/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.converter;

/**
 * Runtime Exception for converter
 * 
 * @author Wayne Jones
 *
 */
public class ConverterRuntimeException extends RuntimeException {

	public ConverterRuntimeException( Exception e ) {
		super( e );
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
