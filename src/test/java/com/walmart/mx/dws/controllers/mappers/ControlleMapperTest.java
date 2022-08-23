package com.walmart.mx.dws.controllers.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.walmart.mx.dws.controllers.forms.RequestForm;
import com.walmart.mx.dws.services.dtos.ProductDto;

class ControlleMapperTest {

    @InjectMocks
    private ControllerMapper mapper;

    ProductDto productDto;

    RequestForm requestForm;

    @BeforeEach
    void setUp() throws Exception {

        MockitoAnnotations.openMocks(this);

        productDto = new ProductDto();

        productDto.setMessageType("objectData");
        productDto.setBarcode(9876543212365L);
        productDto.setMachineId("Eco1");
        productDto.setWeight(1);
        productDto.setWeightUOM("kg");
        productDto.setLength(2);
        productDto.setLengthUOM("dm");
        productDto.setWidth(3);
        productDto.setWidthUOM("dm");
        productDto.setHeight(4);
        productDto.setHeightUOM("dm");
        productDto.setTimeStamp("2021-09-04T13:24:55.534Z");

        requestForm = new RequestForm();

        requestForm.setMessageType("objectData");
        requestForm.setBarcode(9876543212365L);
        requestForm.setMachineId("Eco1");
        requestForm.setWeight(1);
        requestForm.setWeightUOM("kg");
        requestForm.setLength(2);
        requestForm.setLengthUOM("dm");
        requestForm.setWidth(3);
        requestForm.setWidthUOM("dm");
        requestForm.setHeight(4);
        requestForm.setHeightUOM("dm");
        requestForm.setTimeStamp("2021-09-04T13:24:55.534Z");

    }

    @Test
    void integrateDwsDataTest() {

        final ProductDto productDtoActual = mapper.fromRequestFormToProductDto(requestForm);

        assertNotNull(productDtoActual);
        assertEquals(productDto.getMessageType(), productDtoActual.getMessageType());
        assertEquals(productDto.getBarcode(), productDtoActual.getBarcode());
        assertEquals(productDto.getMachineId(), productDtoActual.getMachineId());
        assertEquals(productDto.getWeight(), productDtoActual.getWeight());
        assertEquals(productDto.getWeightUOM(), productDtoActual.getWeightUOM());
        assertEquals(productDto.getLength(), productDtoActual.getLength());
        assertEquals(productDto.getLengthUOM(), productDtoActual.getLengthUOM());
        assertEquals(productDto.getWidth(), productDtoActual.getWidth());
        assertEquals(productDto.getWidthUOM(), productDtoActual.getWidthUOM());
        assertEquals(productDto.getHeight(), productDtoActual.getHeight());
        assertEquals(productDto.getHeightUOM(), productDtoActual.getHeightUOM());
        assertEquals(productDto.getTimeStamp(), productDtoActual.getTimeStamp());

    }

}
