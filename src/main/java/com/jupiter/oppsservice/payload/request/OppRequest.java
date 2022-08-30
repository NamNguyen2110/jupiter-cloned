package com.jupiter.oppsservice.payload.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OppRequest implements Serializable {

    @NotNull()
    @Pattern(regexp = "GDC|FP")
    private String oppType;

    @ApiModelProperty(example = "default")
    @NotBlank()
    private String oppName;

    @ApiModelProperty(example = "default")
    @NotBlank()
    private String customerName;

    @NotBlank()
    private String salesPic;

    @ApiModelProperty(example = "default")
    @NotBlank()
    private String duPic;

    private String leadPic;

    @Pattern(regexp = "NEW")
    private String status;

    @NotNull
    @NotEmpty()
    private List<@Valid OppRequirementRequest> oppRequirements;

    //
    //    private List<OppApplicationDto> oppApplications;


}
