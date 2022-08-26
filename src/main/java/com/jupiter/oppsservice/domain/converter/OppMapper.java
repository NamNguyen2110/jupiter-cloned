package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.dto.OppDto;
import com.jupiter.oppsservice.domain.entity.Opportunity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OppMapper {
    @Mapping(target = "oppApplicationDtoList", source = "oppApplications")
    @Mapping(target = "oppRequirementDtoList", source = "oppRequirements")
    @Mapping(target = "oppSaleDtoList", source = "oppSales")
    OppDto toDto(Opportunity opportunity);
}
