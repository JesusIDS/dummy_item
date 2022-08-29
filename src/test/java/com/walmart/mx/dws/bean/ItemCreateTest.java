package com.walmart.mx.dws.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.walmart.mx.dws.controller.forms.Attr;
import com.walmart.mx.dws.controller.forms.Item;
import com.walmart.mx.dws.controller.forms.Items;

class ItemCreateTest {

    @InjectMocks
    private ItemCreate itemCreate;

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
    void testGetExample() {
        final Items itemBean = itemCreate.getExample();
        assertNotNull(itemBean);
        assertEquals(itemBean.getItem().getAttrs().get(0).getName(), items.getItem().getAttrs().get(0).getName());
        assertEquals(itemBean.getItem().getAttrs().get(0).getValue(), items.getItem().getAttrs().get(0).getValue());

    }

}
