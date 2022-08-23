package com.walmart.mx.dws.services.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.walmart.mx.dws.repositories.entities.DwsProduct;
import com.walmart.mx.dws.services.dtos.ProductDto;

@Component
public class ServiceMapper implements IServiceMapper {

    @Override
    public ProductDto fromProductToProductDto(final DwsProduct from) {

        final ProductDto to = new ProductDto();

        to.setMessageType(from.getMessageType());
        to.setBarcode(from.getBarcode());
        to.setMachineId(from.getMachineId());
        to.setWeight(from.getWeight());
        to.setWeightUOM(from.getWeightUOM());
        to.setLength(from.getLength());
        to.setLengthUOM(from.getLengthUOM());
        to.setWidth(from.getWidth());
        to.setWidthUOM(from.getWidthUOM());
        to.setHeight(from.getHeight());
        to.setHeightUOM(from.getHeightUOM());
        to.setTimeStamp(from.getTimeStamp());

        return to;

    }

    @Override
    public DwsProduct fromProductDtoToProduct(final ProductDto from) {

        final DwsProduct to = new DwsProduct();

        to.setMessageType(from.getMessageType());
        to.setBarcode(from.getBarcode());
        to.setMachineId(from.getMachineId());
        to.setWeight(from.getWeight());
        to.setWeightUOM(from.getWeightUOM());
        to.setLength(from.getLength());
        to.setLengthUOM(from.getLengthUOM());
        to.setWidth(from.getWidth());
        to.setWidthUOM(from.getWidthUOM());
        to.setHeight(from.getHeight());
        to.setHeightUOM(from.getHeightUOM());
        to.setTimeStamp(from.getTimeStamp());

        return to;
    }

    @Override
    public List<ProductDto> fromListProductToListProductDto(final List<DwsProduct> from) {

        final List<ProductDto> to = new ArrayList<ProductDto>();

        for (final DwsProduct product : from) {
            to.add(fromProductToProductDto(product));

        }

        return to;

    }

}
