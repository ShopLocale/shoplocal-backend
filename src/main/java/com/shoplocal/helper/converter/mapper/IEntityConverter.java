package com.shoplocal.helper.converter.mapper;

import com.shoplocal.dto.application.BaseDTO;
import com.shoplocal.entity.BaseEntity;

/**
 * Date: 24/12/20
 *
 * @author Kushal Roy
 */
public interface IEntityConverter<S extends BaseDTO, T extends BaseEntity> {

  T map(S source);

  S map(T target);
}
