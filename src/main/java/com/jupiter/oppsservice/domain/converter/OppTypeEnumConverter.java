package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.OppType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OppTypeEnumConverter implements AttributeConverter<OppType, String> {
    @Override
    public String convertToDatabaseColumn(OppType attribute) {
        return attribute.getValue();
    }

    @Override
    public OppType convertToEntityAttribute(String dbData) {
        return OppType.of(dbData);
    }
}
