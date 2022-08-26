package com.jupiter.oppsservice.domain.converter;
import com.jupiter.oppsservice.domain.enums.OppAppStatus;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OppAppStatusEnumConverter implements AttributeConverter<OppAppStatus, String> {
    @Override
    public String convertToDatabaseColumn(OppAppStatus attribute) {
        return attribute.getValue();
    }

    @Override
    public OppAppStatus convertToEntityAttribute(String dbData) {
        return OppAppStatus.of(dbData);
    }
}
