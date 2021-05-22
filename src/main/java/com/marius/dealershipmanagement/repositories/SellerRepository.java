package com.marius.dealershipmanagement.repositories;

import com.marius.dealershipmanagement.models.Seller;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SellerRepository extends Repository<Seller, Integer> {

    // Return all sellers
    List<Seller> findAll();

    // Find seller by last name
    List<Seller> findByLastNameContaining(String name);

    //find seller by id
    Seller findSellerById(Integer id);

    // Add seller to database
    void save(Seller seller);

    // delete seller by id
    void deleteById(Integer id);

}
