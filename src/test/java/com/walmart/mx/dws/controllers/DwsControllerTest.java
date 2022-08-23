package com.walmart.mx.dws.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.walmart.mx.dws.controllers.forms.RequestForm;
import com.walmart.mx.dws.controllers.forms.ResponseForm;
import com.walmart.mx.dws.controllers.mappers.IControllerMapper;
import com.walmart.mx.dws.services.IDwsService;
import com.walmart.mx.dws.services.dtos.ProductDto;

class DwsControllerTest {

    private static final String PRUEBA_OK = "Prueba ok";

    @InjectMocks
    private DwsController controller;

    @Mock
    private IDwsService service;

    @Mock
    private IControllerMapper mapper;

    ProductDto productDto;

    RequestForm requestForm;

    List<RequestForm> requestFormList;

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

        requestFormList = new ArrayList<RequestForm>();

        requestFormList.add(requestForm);

    }

    @Test
    void integrateDwsDataTest() {

        when(service.compareData(any(ProductDto.class))).thenReturn(productDto);
        when(mapper.fromRequestFormToProductDto(any(RequestForm.class))).thenReturn(productDto);

        final ResponseEntity<ResponseForm> integrateDwsData = controller.integrateDwsData(requestForm);

        assertNotNull(integrateDwsData);
        assertNotNull(integrateDwsData.getBody());
        assertEquals(HttpStatus.OK, integrateDwsData.getStatusCode());
        assertEquals(PRUEBA_OK, integrateDwsData.getBody().getStatus());
    }

    @Test
    void postTest() {

        final ResponseEntity<ResponseForm> response = controller.post(requestFormList);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(PRUEBA_OK, response.getBody().getStatus());
    }

    @Test
    void postListTest() {

        final ResponseEntity<List<ResponseForm>> response = controller.postList(requestFormList);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(PRUEBA_OK, response.getBody().get(0).getStatus());
    }

}