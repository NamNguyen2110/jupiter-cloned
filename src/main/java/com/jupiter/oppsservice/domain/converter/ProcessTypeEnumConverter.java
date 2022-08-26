package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.ProcessType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProcessTypeEnumConverter implements AttributeConverter<ProcessType, String> {
    @Override
    public String convertToDatabaseColumn(ProcessType attribute) {
        return attribute.getValue();
    }

    @Override
    public ProcessType convertToEntityAttribute(String dbData) {
        return ProcessType.of(dbData);
    }
}
