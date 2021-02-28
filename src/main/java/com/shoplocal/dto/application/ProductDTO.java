package com.shoplocal.dto.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoplocal.dto.minimal.ShopMinimalDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Date: 01/01/21
 *
 * @author Sagar Jain
 */

@Data
@ApiModel(value = "ProductDTO")
public class ProductDTO extends BaseDTO {

	@JsonProperty("productId")
	@ApiModelProperty(value = "productId")
	private UUID id;

	private String name;

	private Double price;

	private String image;

	private Boolean active;

	private ShopMinimalDTO shop;

	private Double size;

	private String metric;

	private String description;

}
