package com.walmart.mx.dws.api.clients.testclient.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.mx.dws.api.clients.testclient.TestPeopleClient;
import com.walmart.mx.dws.api.clients.testclient.TestTextClient;
import com.walmart.mx.dws.api.clients.testclient.models.People;
import com.walmart.mx.dws.api.clients.testclient.models.Text;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PeopleContoller {
     private final TestPeopleClient testClient;
     private final TestTextClient txtClient;

     @Value("${backhaul.app.version}")
     private String version;


    @GetMapping("/people")
    public ResponseEntity<List<People>> getPeople() {
       
        return new ResponseEntity<>(testClient.fetchPeople(), HttpStatus.OK);
    }


    @GetMapping("/holaMundo")
    public ResponseEntity<String> sayHello() {
       
        return new ResponseEntity<>("Hola Mundo", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<String> home(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
                locale);
        String formattedDate = dateFormat.format(new Date());
        String mensaje = "Welcome, prueba demo de health check. Backhaul Comunes: Ver " + " "+version;
        return new ResponseEntity<>(mensaje + " "+formattedDate, HttpStatus.OK);

    }

    @PostMapping("/text")
    public ResponseEntity<Text> changeText(@RequestBody String text) {
       
        return new ResponseEntity<>(txtClient.changeText(text), HttpStatus.OK);
    }

}