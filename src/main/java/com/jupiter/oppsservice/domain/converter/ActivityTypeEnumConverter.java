package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.ProjectType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ActivityTypeEnumConverter implements AttributeConverter<ActivityType, String> {
    @Override
    public String convertToDatabaseColumn(ActivityType attribute) {
        return attribute.getValue();
    }

    @Override
    public ActivityType convertToEntityAttribute(String dbData) {
        return ActivityType.of(dbData);
    }
}
