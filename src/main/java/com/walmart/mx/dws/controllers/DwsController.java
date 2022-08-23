package com.walmart.mx.dws.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.mx.dws.controllers.forms.RequestForm;
import com.walmart.mx.dws.controllers.forms.ResponseForm;
import com.walmart.mx.dws.controllers.mappers.IControllerMapper;
import com.walmart.mx.dws.services.IDwsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("api/v01")
public class DwsController {

    @Autowired
    private IDwsService service;

    @Autowired
    private IControllerMapper mapper;

    @Operation(summary = "Send DWS Static and DWS Dynamic information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Integration", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseForm.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping(value = "/dws", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseForm> integrateDwsData(@RequestBody final RequestForm form) {

        final ResponseForm responseForm = new ResponseForm();

        responseForm.setStatus("Prueba ok");
        System.out.println(form.toString());

        service.compareData(mapper.fromRequestFormToProductDto(form));

        return ResponseEntity.ok().body(responseForm);
    }

    @Operation(summary = "Send a List of DWS Static and DWS Dynamic information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Integration", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseForm.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping(value = "/dws/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseForm> post(@RequestBody final List<RequestForm> formList) {

        final ResponseForm responseForm = new ResponseForm();

        responseForm.setStatus("Prueba ok");

        for (final RequestForm request : formList) {
            System.out.println(request.toString());
        }

        return ResponseEntity.ok().body(responseForm);
    }

    @Operation(summary = "Send a List of DWS Static and DWS Dynamic information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Integration", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseForm.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content) })
    @PostMapping(value = "/dws/list2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseForm>> postList(@RequestBody final List<RequestForm> formList) {

        final List<ResponseForm> responseList = new ArrayList<ResponseForm>();
        final ResponseForm responseForm = new ResponseForm();

        responseForm.setStatus("Prueba ok");

        for (final RequestForm request : formList) {
            System.out.println(request.toString());
            responseList.add(responseForm);
        }

        return ResponseEntity.ok().body(responseList);
    }

}
