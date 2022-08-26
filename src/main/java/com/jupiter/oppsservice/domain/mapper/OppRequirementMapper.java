package com.jupiter.oppsservice.domain.mapper;

import com.jupiter.oppsservice.domain.dto.request.OppRequirementRequest;
import com.jupiter.oppsservice.domain.entity.OppRequirement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OppRequirementMapper {
    OppRequirement toEntity(OppRequirementRequest request);

    List<OppRequirement> toEntityList(List<OppRequirementRequest> request);
}
