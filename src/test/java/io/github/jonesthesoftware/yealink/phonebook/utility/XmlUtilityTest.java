/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.utility;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.Document;

/**
 * JUnit tests for the XML Utility class
 * 
 * @author Wayne Jones
 *
 */
@ExtendWith( MockitoExtension.class )
public class XmlUtilityTest {
	
	private XmlUtility xmlUtility;
	
	@BeforeEach
	public void setup() {
		xmlUtility = new XmlUtility();
	}
	
	@Test
	public void newDocumentTest() throws ParserConfigurationException {
		Document document = xmlUtility.newDocument();
		assertNotNull( document );
	}
	
}
