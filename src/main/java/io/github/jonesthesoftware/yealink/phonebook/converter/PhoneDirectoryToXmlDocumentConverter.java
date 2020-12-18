/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.converter;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import io.github.jonesthesoftware.yealink.phonebook.type.DirectoryEntry;
import io.github.jonesthesoftware.yealink.phonebook.type.Directory;
import io.github.jonesthesoftware.yealink.phonebook.utility.XmlUtility;
import io.github.jonesthesoftware.yealink.phonebook.xml.PhoneBookElement;

/**
 * Spring Converter to convert from a Phone Directory to an XML Document
 * The XML document represents the Yealink IP Phone Directory, which in reality is a pseudo XML document.
 * Conversion is performed through DOM manipulation because no XSD exists for the Yealink definition.
 * 
 * @author Wayne Jones
 *
 */
@Component
public class PhoneDirectoryToXmlDocumentConverter implements Converter<Directory, Document> {
	
	private XmlUtility xmlUtility;
	
	@Inject
	PhoneDirectoryToXmlDocumentConverter( XmlUtility xmlUtility ) {
		this.xmlUtility = xmlUtility;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Document convert( Directory phoneDirectory ) {
		Document document;
		try {
			document = xmlUtility.newDocument();
		} catch ( ParserConfigurationException e ) {
			throw new ConverterRuntimeException( e );
		}
		Element directoryElement = xmlUtility.addDocumentElement( document, phoneDirectory.getName() + PhoneBookElement.DIRECTORY_POSTFIX );
		phoneDirectory.getDirectoryEntries().forEach( 
			de -> { 
				Element directoryEntryElement = xmlUtility.addContainerElement( directoryElement, PhoneBookElement.DIRECTORY_ENTRY ); 
				convertDirectoryEntry( de, directoryEntryElement );
			} 
		);
		return document;
	}
	
	/**
	 * Convert a Directory Entry into the Directory Entry Element
	 * @param directoryEntry the directory entry to convert
	 * @param directoryEntryElement the parent element, representing the directory entry element
	 * @return
	 */
	protected void convertDirectoryEntry( DirectoryEntry directoryEntry, Element directoryEntryElement ) {
		xmlUtility.addTextElement( directoryEntryElement, PhoneBookElement.CONTACT_NAME, directoryEntry.getName() );
		directoryEntry.getTelephone().forEach( 
				p -> xmlUtility.addTextElement( directoryEntryElement, PhoneBookElement.PHONE_NUMBER, p ) 
		);
	}
	
}
