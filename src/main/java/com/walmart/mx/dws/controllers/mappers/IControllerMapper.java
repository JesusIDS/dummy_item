package com.walmart.mx.dws.controllers.mappers;

import com.walmart.mx.dws.controllers.forms.RequestForm;
import com.walmart.mx.dws.services.dtos.ProductDto;

public interface IControllerMapper {

    public ProductDto fromRequestFormToProductDto(RequestForm from);

}