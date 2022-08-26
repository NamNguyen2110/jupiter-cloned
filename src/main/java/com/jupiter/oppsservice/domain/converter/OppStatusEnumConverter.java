package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.OppStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OppStatusEnumConverter implements AttributeConverter<OppStatus, String> {
    @Override
    public String convertToDatabaseColumn(OppStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public OppStatus convertToEntityAttribute(String dbData) {
        return OppStatus.of(dbData);
    }
}
