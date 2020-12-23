/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import io.github.jonesthesoftware.yealink.phonebook.jpa.type.Directory;
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.DirectoryEntry;
import io.github.jonesthesoftware.yealink.phonebook.jpa.type.PhoneEntry;
import io.github.jonesthesoftware.yealink.phonebook.utility.XmlUtility;
import io.github.jonesthesoftware.yealink.phonebook.xml.PhoneBookElement;

/**
 * JUnit tests for the Phone Directory to (Yealink XML) Document Converter
 * 
 * @author Wayne Jones
 *
 */
@ExtendWith( MockitoExtension.class )
public class PhoneDirectoryToXmlDocumentConverterTest {
	
	private static final String DIRECTORY_NAME = "Home";
	private static final String EXPECTED_DOCUMENT_NAME = DIRECTORY_NAME + PhoneBookElement.DIRECTORY_POSTFIX;
	
	@Mock 
	private XmlUtility mockXmlUtility;
	
	@Spy
	@InjectMocks
	private PhoneDirectoryToXmlDocumentConverter phoneDirectoryToXmlDocumentConverterSpy;

	/**
	 * Test a conversion from the internal representation of a Phone Directory to the Yealink XML Representation
	 *  
	 * @throws ParserConfigurationException
	 */
	@Test
	public void convertTest() throws ParserConfigurationException {
		Directory directory = new Directory();
		directory.setDirectoryName( DIRECTORY_NAME );
		DirectoryEntry directoryEntry = new DirectoryEntry();
		directory.getDirectoryEntries().add( directoryEntry );
		
		Document mockDocument = Mockito.mock( Document.class );
		Element mockDirectoryElement = Mockito.mock( Element.class );
		Element mockDirectoryEntryElement = Mockito.mock( Element.class );
		when( mockXmlUtility.newDocument() )
			.thenReturn( mockDocument );
		when( mockXmlUtility.addDocumentElement( mockDocument, EXPECTED_DOCUMENT_NAME ) )
			.thenReturn( mockDirectoryElement );
		when( mockXmlUtility.addContainerElement( mockDirectoryElement, PhoneBookElement.DIRECTORY_ENTRY ) )
			.thenReturn( mockDirectoryEntryElement );
		
		Document document = phoneDirectoryToXmlDocumentConverterSpy.convert( directory );
		
		verify( mockXmlUtility ).newDocument();
		verify( mockXmlUtility ).addDocumentElement( mockDocument, EXPECTED_DOCUMENT_NAME );
		verify( mockXmlUtility ).addContainerElement( mockDirectoryElement, PhoneBookElement.DIRECTORY_ENTRY );
		verify( phoneDirectoryToXmlDocumentConverterSpy ).convertDirectoryEntry( directoryEntry, mockDirectoryEntryElement );
		
		assertThat( document, is( mockDocument ) );
	}
	
	/**
	 * Provides parameters for the convertDirectoryEntryTest method
	 * Each list is provided to the conversion test method individually; results in tests for 1, 2, and 3 phone numbers.
	 * 
	 * @return a stream of parameters which are used to provide the values for testing the directory entry
	 */
	private static Stream<Arguments> provideCollectionForAddContactTest() {
		return Stream.of(
			Arguments.of( "James", null, List.of( "0123456789" ), "James" ),
			Arguments.of( "David", "Jones", List.of( "0123456789", "0987654321" ), "David Jones" ),
			Arguments.of( "Beth Anne", "Butler", List.of( "0123456789", "0987654321", "0918273645" ), "Beth Anne Butler" )
	    );
	}
	
	/**
	 * Test conversion from the internal representation of Directory Entry to a Yealink XML Element
	 * This test runs 3 times using the arguments supplied by the method provideCollectionForAddContactTest
	 * The Yealink XML allows up to 3 phone numbers to be included against a directory entry
	 *  
	 * @param phoneNumbers
	 */
	@ParameterizedTest
	@MethodSource( "provideCollectionForAddContactTest" )
	public void convertDirectoryEntryTest( String firstName, String lastName, Collection<String> phoneNumbers, String expectedName ) {
		DirectoryEntry directoryEntry = new DirectoryEntry();
		directoryEntry.setFirstName( firstName );
		directoryEntry.setLastName( lastName );
		directoryEntry.getPhoneEntries().addAll(
			phoneNumbers.stream().map(
					p -> {
						PhoneEntry phoneEntry = new PhoneEntry();
						phoneEntry.setPhoneNumber( p );
						return phoneEntry;
					}
			).collect( Collectors.toList() ) 
		);
				
		Element mockDirectoryEntryElement = Mockito.mock( Element.class );
				
		phoneDirectoryToXmlDocumentConverterSpy.convertDirectoryEntry( directoryEntry, mockDirectoryEntryElement );
		
	    verify( mockXmlUtility )
	    	.addTextElement( mockDirectoryEntryElement, PhoneBookElement.CONTACT_NAME, expectedName );
		phoneNumbers.forEach( p -> {
	    		verify( mockXmlUtility ).addTextElement( mockDirectoryEntryElement, PhoneBookElement.PHONE_NUMBER, p );
	    } );
		
	}

}
