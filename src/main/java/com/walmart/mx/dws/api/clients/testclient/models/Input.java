package com.walmart.mx.dws.api.clients.testclient.models;

import lombok.Data;

@Data
public class Input {
    
    public Input(String text) {
        this.input=text;
    }
    private String input;
}
