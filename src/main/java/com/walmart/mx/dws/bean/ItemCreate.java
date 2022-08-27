package com.walmart.mx.dws.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.walmart.mx.dws.controller.forms.Attr;
import com.walmart.mx.dws.controller.forms.Item;
import com.walmart.mx.dws.controller.forms.Items;

@Component
public class ItemCreate {

    public Items getExample() {

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

        final Items items = new Items();
        items.setItem(item);

        return items;
    }
}
