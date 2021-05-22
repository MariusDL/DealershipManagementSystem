package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Vehicle;
import com.marius.dealershipmanagement.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
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
        model.put("vehicleToFind", new Vehicle());
        return "vehicles/vehicles";
    }

    @PostMapping("/vehicles")
    public String findVehicle(Map<String, Object> model, @ModelAttribute Vehicle vehicleToFind){
        List<Vehicle> vehicles = vehicleRepository.findByRegContaining(vehicleToFind.getReg().toUpperCase());
        model.put("vehicles",vehicles);
        model.put("vehicleToFind", new Vehicle());
        return "vehicles/vehicles";
    }

    @GetMapping("/new-vehicle")
    public String addNewVehicle(Map<String, Object> model){
        model.put("vehicle", new Vehicle());

        return "vehicles/addUpdateVehicleForm";
    }

    @PostMapping("/new-vehicle")
    public String addVehicle(@Valid Vehicle vehicle, BindingResult result){

        if (result.hasErrors()) {
            return "vehicles/addUpdateVehicleForm";
        } else {
            this.vehicleRepository.save(vehicle);
        }

        return "redirect:/vehicles";
    }
}
