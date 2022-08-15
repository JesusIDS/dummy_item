package com.walmart.mx.dws.api.clients.testclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Text {

    @JsonProperty("OUTPUT")
    private String output;
    @JsonProperty("INPUT")
    private String input;
    
}
