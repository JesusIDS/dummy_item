package com.walmart.mx.dws.controllers.forms;

import lombok.Data;

@Data
public class RequestForm {

    private String messageType;
    private Long barcode;
    private String machineId;
    private Integer weight;
    private String weightUOM;
    private Integer length;
    private String lengthUOM;
    private Integer width;
    private String widthUOM;
    private Integer height;
    private String heightUOM;
    private String timeStamp;

}
