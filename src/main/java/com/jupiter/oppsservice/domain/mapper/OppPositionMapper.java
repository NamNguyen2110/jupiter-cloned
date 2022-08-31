package com.jupiter.oppsservice.domain.mapper;

import com.jupiter.oppsservice.domain.dto.request.OppPositionRequest;
import com.jupiter.oppsservice.domain.entity.OppPosition;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OppPositionMapper {
    OppPosition toEntity(OppPositionRequest request);

    List<OppPosition> toEntityList(List<OppPositionRequest> request);
}
