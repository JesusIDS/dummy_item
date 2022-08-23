package com.walmart.mx.dws.controllers.mappers;

import org.springframework.stereotype.Component;

import com.walmart.mx.dws.controllers.forms.RequestForm;
import com.walmart.mx.dws.services.dtos.ProductDto;

@Component
public class ControllerMapper implements IControllerMapper {

    @Override
    public ProductDto fromRequestFormToProductDto(final RequestForm from) {

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

}
