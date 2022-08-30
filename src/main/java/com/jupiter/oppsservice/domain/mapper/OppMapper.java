package com.jupiter.oppsservice.domain.mapper;

import com.jupiter.oppsservice.domain.dto.request.OppRequest;
import com.jupiter.oppsservice.domain.dto.response.OppResponse;
import com.jupiter.oppsservice.domain.entity.Opp;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface OppMapper {
    Opp toEntity(OppRequest request);

    OppResponse toDto(Opp request);
}
