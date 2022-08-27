package com.walmart.mx.dws.controller.forms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Item implements Serializable {

    private static final long serialVersionUID = 22L;

    @JacksonXmlProperty(localName = "attr")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Attr> attrs = new ArrayList<>();

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(final List<Attr> attrs) {
        this.attrs = attrs;
    }

    @Override
    public String toString() {
        return "Item [attrs=" + attrs + "]";
    }

}
