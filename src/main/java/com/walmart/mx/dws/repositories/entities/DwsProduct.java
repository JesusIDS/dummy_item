package com.walmart.mx.dws.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DwsProduct {

    @Id
    @GeneratedValue
    private Long id;
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
