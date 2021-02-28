package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "CategoryDTO")
public class CategoryDTO extends BaseDTO {

  @JsonProperty("categoryId")
  @ApiModelProperty(value = "categoryId")
  private UUID id;

  private String type;

  private String image;
}
