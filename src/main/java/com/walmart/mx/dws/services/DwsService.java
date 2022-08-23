package com.walmart.mx.dws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.mx.dws.repositories.IDwsRepository;
import com.walmart.mx.dws.repositories.entities.DwsProduct;
import com.walmart.mx.dws.services.dtos.ProductDto;
import com.walmart.mx.dws.services.mappers.IServiceMapper;

@Service
public class DwsService implements IDwsService {

    @Autowired
    private IDwsRepository repository;

    @Autowired
    private IServiceMapper mapper;

    @Override
    public List<ProductDto> findAll() {
        return mapper.fromListProductToListProductDto(repository.findAll());
    }

    @Override
    public ProductDto compareData(final ProductDto productDto) {
        // TODO Simulacion de objetos diferentes para guardado en base de datos
        final DwsProduct product = mapper.fromProductDtoToProduct(productDto);

        return mapper.fromProductToProductDto(repository.save(product));
    }

    @Override
    public void setWeightPorcentage(final Integer porcentage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setVolumePorcentage(final Integer porcentage) {
        // TODO Auto-generated method stub

    }

    // Privado
    // Get item file data
    // Calculo de variacion de porcentaje/Peso
    // Calculo de variacion de porcentaje/Volumen
    // Notificacion de errores

}