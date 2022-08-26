package com.jupiter.oppsservice.domain.converter;

import com.jupiter.oppsservice.domain.dto.OppDto;
import com.jupiter.oppsservice.domain.dto.OppRequirementDto;
import com.jupiter.oppsservice.domain.entity.Opportunity;
import com.jupiter.oppsservice.domain.entity.OpportunityRequirement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OppRequirementMapper {
    @Mapping(target = "oppDto", source = "opportunity")
    OppRequirementDto toDto(OpportunityRequirement oppRequirement);
}
