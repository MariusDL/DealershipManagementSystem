package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Vehicle;
import com.marius.dealershipmanagement.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Returns a list with all the vehicles
    @GetMapping("/vehicles")
    public String showAllVehicles(Map<String, Object> model){
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.put("vehicles",vehicles);
        model.put("vehicleToFind", new Vehicle());
        return "vehicles/vehicles";
    }

    // Used to find vehicles by registration number
    // Returns a list with found vehicles
    @PostMapping("/vehicles")
    public String findVehicle(Map<String, Object> model, @ModelAttribute Vehicle vehicleToFind){
        List<Vehicle> vehicles = vehicleRepository.findByRegContaining(vehicleToFind.getReg().toUpperCase());
        model.put("vehicles",vehicles);
        model.put("vehicleToFind", new Vehicle());
        return "vehicles/vehicles";
    }

    // Returns the form to add a new vehicle
    @GetMapping("/new-vehicle")
    public String addNewVehicle(Map<String, Object> model){
        model.put("vehicle", new Vehicle());

        return "vehicles/addUpdateVehicleForm";
    }

    // Adds the new vehicle to the database
    @PostMapping("/new-vehicle")
    public String addVehicle(@Valid Vehicle vehicle, BindingResult result){

        if (result.hasErrors()) {
            return "vehicles/addUpdateVehicleForm";
        } else {
            this.vehicleRepository.save(vehicle);
        }

        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/{vehicleId}")
    public String editVehicle(@PathVariable("vehicleId") int vehicleId, Map<String, Object> model){

        Vehicle vehicle = this.vehicleRepository.findVehicleById(vehicleId);

        model.put("vehicle", vehicle);

        return "vehicles/addUpdateVehicleForm";
    }

    @GetMapping("/vehicles/{vehicleId}/delete")
    public String deleteVehicle(@PathVariable("vehicleId") int vehicleId){

        this.vehicleRepository.deleteById(vehicleId);



        return "redirect:/vehicles";
    }
}
