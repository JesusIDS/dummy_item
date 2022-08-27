package com.walmart.mx.dws.controller.forms;

import lombok.Data;

@Data
public class RequestForm {
    private String itemNbr;
    private String caseUpcNbr;
    private String vnpkWeightQty;
    private String vnpkLengthQty;
    private String vnpkWidthQty;
    private String vnpkHeightQty;
    private String lastUpdatePgmId;
}
