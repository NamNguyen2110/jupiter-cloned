package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.Level;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LevelEnumConverter implements AttributeConverter<Level, String> {
    @Override
    public String convertToDatabaseColumn(Level attribute) {
        return attribute.getValue();
    }

    @Override
    public Level convertToEntityAttribute(String dbData) {
        return Level.of(dbData);
    }
}
