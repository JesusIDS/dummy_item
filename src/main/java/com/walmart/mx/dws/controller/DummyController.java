package com.walmart.mx.dws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.mx.dws.bean.ItemCreate;
import com.walmart.mx.dws.controller.forms.Item;
import com.walmart.mx.dws.controller.forms.Items;
import com.walmart.mx.dws.controller.forms.RequestForm;
import com.walmart.mx.dws.controller.forms.ResponseForm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v01")
public class DummyController {

    @Autowired
    private ItemCreate item;

    @Operation(summary = "Send Item File Information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Integration", content = {
                    @Content(mediaType = "application/xml", schema = @Schema(implementation = Item.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @GetMapping(value = "/item/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Items> get(@PathVariable final Long id) {
        System.out.println(item.getExample().toString());
        return ResponseEntity.ok().body(item.getExample());
    }

    @Operation(summary = "Send Item File Confirmation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Integration", content = {
                    @Content(mediaType = "application/xml", schema = @Schema(implementation = ResponseForm.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping(value = "/item/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> post(@PathVariable final Long id, @RequestBody final RequestForm form) {
        final ResponseForm response = new ResponseForm();
        response.setStatus("Status OK");
        return ResponseEntity.ok().body(response);
    }

}
