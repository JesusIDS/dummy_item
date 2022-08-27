package com.walmart.mx.dws.controller.forms;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "attr")
public class Attr {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty
    @JacksonXmlText
    private String value;

    public Attr(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attr [name=" + name + ", value=" + value + "]";
    }

}
