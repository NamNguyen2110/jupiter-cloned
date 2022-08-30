package com.jupiter.oppsservice.domain.mapper;

import com.jupiter.oppsservice.domain.entity.OppPosition;
import com.jupiter.oppsservice.payload.request.OppRequirementRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OppRequirementMapper {
    OppPosition toEntity(OppRequirementRequest request);

    List<OppPosition> toEntityList(List<OppRequirementRequest> request);
}
