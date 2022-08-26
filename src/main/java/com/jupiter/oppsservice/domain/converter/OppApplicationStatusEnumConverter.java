package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.ApplicationStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OppApplicationStatusEnumConverter implements AttributeConverter<ApplicationStatus, String> {
    @Override
    public String convertToDatabaseColumn(ApplicationStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public ApplicationStatus convertToEntityAttribute(String dbData) {
        return ApplicationStatus.of(dbData);
    }
}
