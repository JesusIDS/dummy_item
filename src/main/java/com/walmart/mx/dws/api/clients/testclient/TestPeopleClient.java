package com.walmart.mx.dws.api.clients.testclient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.walmart.mx.dws.api.clients.testclient.models.People;

@Component
public class TestPeopleClient {
 
    WebClient webClient = WebClient.builder()
    .baseUrl("https://ghibliapi.herokuapp.com")
    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    .build();
            
    public List<People> fetchPeople(){
        return Arrays.stream(webClient.get().uri("/people").retrieve().bodyToMono(People[].class).block()).collect(Collectors.toList());
    }  


}
