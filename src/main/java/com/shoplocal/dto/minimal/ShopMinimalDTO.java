package com.shoplocal.dto.minimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoplocal.dto.application.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Date: 02/01/21
 *
 * @author Sagar Jain
 */
@Data
@ApiModel(value = "ShopMinimalDTO")
public class ShopMinimalDTO extends BaseDTO {

	@JsonProperty("shopId")
	@ApiModelProperty(value = "shopId")
	private UUID id;

}
