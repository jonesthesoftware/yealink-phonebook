/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.utility;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Utility for managing simple XML / DOM documents 
 * 
 * @author Wayne Jones
 *
 */
@Component
public class XmlUtility {

	/**
	 * Create a new XML document
	 * 
	 * @return the instantiated XML document
	 * @throws ParserConfigurationException 
	 */
	public Document newDocument() throws ParserConfigurationException {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		documentBuilder = documentFactory.newDocumentBuilder();				
		return documentBuilder.newDocument();
	}
	
	/**
	 * Add a document (root) element to the XML document
	 * 
	 * @param document the document to add the root element to
	 * @param elementName the name of the root element
	 * @return the root element created
	 */
	public Element addDocumentElement( Document document, String elementName ) {
 		Element documentElement = document.createElement( elementName ); 
 		document.appendChild( documentElement );
		return documentElement;
	}
	
	/**
	 * Add a container element to the document
	 * The container element is used as a parent for other nodes
	 * 
	 * @param parentElement the parent element for this container element
	 * @param elementName the name of the element to create
	 * @return the element created
	 */
	public Element addContainerElement( Element parentElement, String elementName ) {
		Document document = parentElement.getOwnerDocument();
 		Element basicElement = document.createElement( elementName ); 
 		parentElement.appendChild( basicElement );
		return basicElement;
	}
	
	/**
	 * Add a text element to the document
	 * 
	 * @param parentElement the parent element for this text element
	 * @param elementName the name of the element to create
	 * @param text the text to associate with the created element 
	 * @return the element created
	 */
	public Element addTextElement( Element parentElement, String elementName, String text ) {
		Document document = parentElement.getOwnerDocument();
 		Element textElement = document.createElement( elementName ); 
 		textElement.setTextContent( text );
 		parentElement.appendChild( textElement );
		return textElement;
	}
	
}
