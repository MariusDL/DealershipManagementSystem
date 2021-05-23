package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Client;
import com.marius.dealershipmanagement.models.Sale;
import com.marius.dealershipmanagement.models.Seller;
import com.marius.dealershipmanagement.models.Vehicle;
import com.marius.dealershipmanagement.repositories.ClientRepository;
import com.marius.dealershipmanagement.repositories.SaleRepository;
import com.marius.dealershipmanagement.repositories.SellerRepository;
import com.marius.dealershipmanagement.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class SaleController {

    private final SaleRepository saleRepository;
    private final ClientRepository clientRepository;
    private final SellerRepository sellerRepository;
    private final VehicleRepository vehicleRepository;

    public SaleController(SaleRepository saleRepository, ClientRepository clientRepository, SellerRepository sellerRepository, VehicleRepository vehicleRepository) {
        this.saleRepository = saleRepository;
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
        this.vehicleRepository = vehicleRepository;
    }


    @GetMapping("/sales")
    public String showAllSales(Map<String, Object> model){
        List<Sale> sales = saleRepository.findAll();
        model.put("sales",sales);
        model.put("saleToFind", new Sale());
        return "sales/sales";
    }

    // Used to find sales by vehicle registration number
    // Returns a list with found sale transactions
    @PostMapping("/sales")
    public String findSaleByVehicleReg(Map<String, Object> model, @ModelAttribute Sale saleToFind){
        List<Sale> sales = saleRepository.findByVehicleRegContaining(saleToFind.getVehicleReg().toUpperCase());
        model.put("sales",sales);
        model.put("saleToFind", new Sale());
        return "sales/sales";
    }

    // Returns the form to sell a vehicle
    @GetMapping("/new-sale")
    public String addNewSale(Map<String, Object> model){

        List<Client> clients = clientRepository.findAll();
        List<Seller> sellers = sellerRepository.findAll();
        List<Vehicle> vehicles = vehicleRepository.findAll();

        model.put("vehicles",vehicles);
        model.put("sellers",sellers);
        model.put("clients",clients);
        model.put("sale", new Sale());

        return "sales/sellVehicleForm";
    }

    @PostMapping("/new-sale")
    public String sellVehicle(@ModelAttribute Sale sale, BindingResult result){

        if (result.hasErrors()) {
            System.out.println(result.getFieldError());
            return "sales/sellVehicleForm";
        } else {

            // if no date has been selected in the calendar
            if(sale.getDateSold() == null){
                sale.setDateSold(LocalDate.now());
            }

            // the details from the form to save the sale in database are incomplete so the rest will be filled automatically
            Vehicle vehicle = vehicleRepository.findVehicleById(sale.getVehicleId());
            sale.setVehicleDetails(vehicle);

            // save sale transaction to database and delete vehicle from the list of vehicles
            saleRepository.save(sale);
            vehicleRepository.deleteById(sale.getVehicleId());


        }
        return "redirect:/sales";
    }

}
