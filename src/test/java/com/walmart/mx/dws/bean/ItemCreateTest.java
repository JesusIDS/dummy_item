package com.walmart.mx.dws.bean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class ItemCreateTest {

    @InjectMocks
    private ItemCreate itemCreate;

    @Test
    void testGetExample() {
        itemCreate = new ItemCreate();
        itemCreate.getExample();
        assertNotNull(itemCreate.getExample());
    }

}
