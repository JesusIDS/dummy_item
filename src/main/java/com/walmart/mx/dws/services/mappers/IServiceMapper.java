package com.walmart.mx.dws.services.mappers;

import java.util.List;

import com.walmart.mx.dws.repositories.entities.DwsProduct;
import com.walmart.mx.dws.services.dtos.ProductDto;

public interface IServiceMapper {

    public ProductDto fromProductToProductDto(DwsProduct from);

    public DwsProduct fromProductDtoToProduct(ProductDto from);

    public List<ProductDto> fromListProductToListProductDto(List<DwsProduct> from);

}
