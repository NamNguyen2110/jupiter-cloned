package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.dto.OppApplicationDto;
import com.jupiter.oppsservice.domain.dto.OppDto;
import com.jupiter.oppsservice.domain.entity.Opportunity;
import com.jupiter.oppsservice.domain.entity.OpportunityApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OppApplicationMapper {
    @Mapping(target = "oppRequirementDto", source = "oppoRequirement")
    @Mapping(target = "oppDto", source = "opportunity")
    OppApplicationDto toDto(OpportunityApplication oppApplication);

}
