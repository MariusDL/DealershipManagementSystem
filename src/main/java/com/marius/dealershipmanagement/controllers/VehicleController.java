package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Vehicle;
import com.marius.dealershipmanagement.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/vehicles")
    public String showAllVehicles(Map<String, Object> model){
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.put("vehicles",vehicles);
        return "vehicles";
    }
}
