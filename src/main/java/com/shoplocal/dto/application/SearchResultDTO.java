package com.shoplocal.dto.application;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class SearchResultDTO {
    private Set<ShopDTO> shops = new HashSet<>();
    private Set<ProductDTO> products = new HashSet<>();
}
