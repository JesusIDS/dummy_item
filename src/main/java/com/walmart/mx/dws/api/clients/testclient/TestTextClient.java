package com.walmart.mx.dws.api.clients.testclient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.walmart.mx.dws.api.clients.testclient.models.Input;
import com.walmart.mx.dws.api.clients.testclient.models.Text;

@Component
public class TestTextClient {
    WebClient webClient = WebClient.builder()
    .baseUrl("HTTP://API.SHOUTCLOUD.IO/V1/SHOUT")
    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    .build();

    public Text changeText(String text){
        return webClient.post().contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
		.body(BodyInserters.fromValue(new Input(text)))
		.retrieve()
		.bodyToMono(Text.class).block();
    }
}
