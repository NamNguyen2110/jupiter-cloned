package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.ApplicationType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ApplicationTypeEnumConverter implements AttributeConverter<ApplicationType, String> {
    @Override
    public String convertToDatabaseColumn(ApplicationType attribute) {
        return attribute.getValue();
    }

    @Override
    public ApplicationType convertToEntityAttribute(String dbData) {
        return ApplicationType.of(dbData);
    }
}
