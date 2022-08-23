package com.walmart.mx.dws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.mx.dws.repositories.entities.DwsProduct;

public interface IDwsRepository extends JpaRepository<DwsProduct, Long> {

}