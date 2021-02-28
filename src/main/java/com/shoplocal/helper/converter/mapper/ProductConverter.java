package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.ProductDTO;
import com.shoplocal.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 01/01/21
 *
 * @author Sagar Jain
 */
@Component
public class ProductConverter implements IEntityConverter<ProductDTO, Product> {

	@Autowired private ModelMapper modelMapper;

	@Override
	public Product map(ProductDTO source) {
		return modelMapper.map(source, Product.class);
	}

	@Override
	public ProductDTO map(Product target) {
		return modelMapper.map(target, ProductDTO.class);
	}
}
