package com.walmart.mx.dws.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.walmart.mx.dws.bean.ItemCreate;
import com.walmart.mx.dws.controller.forms.Attr;
import com.walmart.mx.dws.controller.forms.Item;
import com.walmart.mx.dws.controller.forms.Items;

import static org.mockito.Mockito.when;

class DummyControllerTest {

    @Mock
    private ItemCreate itemCreate;

    @InjectMocks
    private DummyController dummyController;

    private Items items;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        items = new Items();

        final List<Attr> attrList = new ArrayList<>();

        attrList.add(new Attr("itemNbr", "235457"));
        attrList.add(new Attr("caseUpcNbr", "856556"));
        attrList.add(new Attr("vnpkWeightQty", "1.0"));
        attrList.add(new Attr("vnpkLengthQty", "1.0"));
        attrList.add(new Attr("vnpkWidthQty", "1.0"));
        attrList.add(new Attr("vnpkHeightQty", "1.0"));
        attrList.add(new Attr("lastUpdatePgmId", "DWS"));
        attrList.add(new Attr("upcFormatCode", "1"));
        attrList.add(new Attr("sellUomCode", "KG"));

        final Item item = new Item();
        item.setAttrs(attrList);
        items.setItem(item);

    }

    @Test
    void testGet() {
        when(itemCreate.getExample()).thenReturn(items);
        final ResponseEntity<Items> responseEntity = dummyController.get(324235l);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(items.getItem().getAttrs().get(0).getName(), responseEntity.getBody().getItem().getAttrs().get(0).getName());
    }

    @Test
    void testPost() {
        fail("Not yet implemented");
    }

}
