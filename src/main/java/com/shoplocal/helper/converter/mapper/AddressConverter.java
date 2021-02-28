package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.AddressDTO;
import com.shoplocal.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 27/02/21
 *
 * @author Sagar Jain
 */
@Component
public class AddressConverter implements IEntityConverter<AddressDTO, Address> {

    @Autowired private ModelMapper modelMapper;

    @Override
    public Address map(AddressDTO source) {
        return modelMapper.map(source, Address.class);
    }

    @Override
    public AddressDTO map(Address target) {
        return modelMapper.map(target, AddressDTO.class);
    }
}
