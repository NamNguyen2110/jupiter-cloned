package com.jupiter.oppsservice.domain.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppRequirementRequest implements Serializable {
    @NotNull()
    @Min(value = 1)
    private Integer quantity;

    @ApiModelProperty(example = "default")
    @NotBlank()
    private String position;

    @ApiModelProperty(example = "default")
    private String level;

    private Double exp;

    @ApiModelProperty(example = "default")
    @NotBlank()
    private String skill;

    @NotBlank()
    private String language;

    @ApiModelProperty(example = "default")
    private String notes;

    private String attachFileUrl;

}
