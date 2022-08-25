package com.jupiter.oppsservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OppsResponseDto extends OppsRequestDto {
    private Long id;
    private Long salePicId;
}
