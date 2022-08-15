package com.walmart.mx.dws.api.clients.testclient.models;

import java.util.List;

import lombok.Data;

@Data
public class People {
    
    private String id;
    private String name;
    private String age;
    private String gender;
    private String eyeColor;
    private String hairColor;
    private String species;
    private String url;
    private List<String> films;

}
