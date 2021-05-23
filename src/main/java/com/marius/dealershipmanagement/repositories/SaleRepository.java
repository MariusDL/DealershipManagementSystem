package com.marius.dealershipmanagement.repositories;

import com.marius.dealershipmanagement.models.Sale;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SaleRepository extends Repository<Sale, Integer> {

    // Return all sales
    List<Sale> findAll();

    // Find sale by car reg
    List<Sale> findByVehicleRegContaining(String reg);

    // Add sale to database
    void save(Sale sale);

}
