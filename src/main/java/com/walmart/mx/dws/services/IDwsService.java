package com.walmart.mx.dws.services;

import java.util.List;

import com.walmart.mx.dws.services.dtos.ProductDto;

public interface IDwsService {

    // Read
    public List<ProductDto> findAll();

    // Compare data (Guardar informacion en azure SQL ¿Aunque no exista una
    // variacion mayor al porcentaje?)
    public ProductDto compareData(ProductDto product);

    // Configurar porcentaje peso (Porcentaje +- 1%)
    public void setWeightPorcentage(Integer porcentage);

    // Configurar porcentaje volumen (Porcentaje de +-5%)
    public void setVolumePorcentage(Integer porcentage);

    // Privado
    // Get item file data
    // Calculo de variacion de porcentaje/Peso
    // Calculo de variacion de porcentaje/Volumen
    // Notificacion de errores

}
