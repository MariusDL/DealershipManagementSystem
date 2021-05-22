package com.marius.dealershipmanagement.repositories;

import com.marius.dealershipmanagement.models.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VehicleRepository extends Repository<Vehicle, Integer> {

    // Return all vehicles
    List<Vehicle> findAll();

    // Find vehicle by registration number
    List<Vehicle> findByRegContaining(String reg);

    //find vehicle by id
    Vehicle findVehicleById(Integer id);

    // Add vehicle to database
    void save(Vehicle vehicle);

    // delete vehicle by id
    void deleteById(Integer id);


}
