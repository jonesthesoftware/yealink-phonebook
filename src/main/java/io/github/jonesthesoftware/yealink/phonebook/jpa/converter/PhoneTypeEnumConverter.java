/**
 * Copyright (C) 2020 Wayne Jones
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package io.github.jonesthesoftware.yealink.phonebook.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.github.jonesthesoftware.yealink.phonebook.jpa.type.PhoneTypeEnum;

@Converter( autoApply = true )
public class PhoneTypeEnumConverter implements AttributeConverter<PhoneTypeEnum, String> {

	@Override
	public String convertToDatabaseColumn( PhoneTypeEnum phoneType ) {
		if ( phoneType == null ) {
			return null;
		}
		return phoneType.getCode();
	}

	@Override
	public PhoneTypeEnum convertToEntityAttribute( String phoneTypeCode ) {
		return PhoneTypeEnum.of( phoneTypeCode );
	}

}
