package com.jupiter.oppsservice.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppRequirementRequest implements Serializable {
    private Integer quantity;

    @ApiModelProperty(example = "default")
    private String position;

    private Double exp;

    @ApiModelProperty(example = "default")
    private String skillStack;

    @ApiModelProperty(example = "default")
    private String note;

    @ApiModelProperty(example = "default")
    private String level;

}
