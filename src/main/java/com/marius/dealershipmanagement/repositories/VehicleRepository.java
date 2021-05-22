package com.marius.dealershipmanagement.repositories;

import com.marius.dealershipmanagement.models.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VehicleRepository extends Repository<Vehicle, Integer> {

    List<Vehicle> findAll();

    @Query("SELECT DISTINCT vehicle FROM Vehicle vehicle WHERE vehicle.reg LIKE :reg%")
    @Transactional(readOnly = true)
    List<Vehicle> findVehicleByReg(@Param("reg") String reg);

    List<Vehicle> findByRegContaining(String reg);

    void save(Vehicle vehicle);

}
