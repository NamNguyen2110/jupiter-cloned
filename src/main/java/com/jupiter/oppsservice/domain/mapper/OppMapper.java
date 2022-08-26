package com.jupiter.oppsservice.domain.mapper;

import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.entity.Opp;
import org.mapstruct.Mapper;

@Mapper
public interface OppMapper {
    Opp toEntity(OppRequest request);
}
