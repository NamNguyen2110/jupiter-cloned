package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.ProjectType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProjectTypeEnumConverter implements AttributeConverter<ProjectType, String> {
    @Override
    public String convertToDatabaseColumn(ProjectType attribute) {
        return attribute.getValue();
    }

    @Override
    public ProjectType convertToEntityAttribute(String dbData) {
        return ProjectType.of(dbData);
    }
}
