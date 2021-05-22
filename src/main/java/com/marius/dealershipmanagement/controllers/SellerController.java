package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Client;
import com.marius.dealershipmanagement.models.Seller;
import com.marius.dealershipmanagement.repositories.SellerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class SellerController {

    private final SellerRepository sellerRepository;

    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    // return a list with all the sellers
    @GetMapping("/sellers")
    public String showAllSellers(Map<String, Object> model){

        List<Seller> sellers = sellerRepository.findAll();

        model.put("sellers", sellers);
        model.put("sellerToFind", new Seller());
        return "/sellers/sellers";
    }

    // Used to find sellers by last name
    // Returns a list with found sellers
    @PostMapping("/sellers")
    public String findSeller(Map<String, Object> model, @ModelAttribute Seller sellerToFind){
        List<Seller> sellers = sellerRepository.findByLastNameContaining(sellerToFind.getLastName());
        model.put("sellers",sellers);
        model.put("sellerToFind", new Seller());
        return "sellers/sellers";
    }

    // Return a form to add a new seller
    @GetMapping("/new-seller")
    public String addNewSeller(Map<String, Object> model){
        model.put("seller", new Seller());

        return "sellers/addUpdateSellerForm";
    }

    // Add new seller to database
    @PostMapping("/new-seller")
    public String addSeller(@Valid Seller seller, BindingResult result){

        if (result.hasErrors()) {
            return "sellers/addUpdateSellerForm";
        } else {
            this.sellerRepository.save(seller);
        }
        return "redirect:/sellers";
    }

    @GetMapping("/sellers/{sellerId}")
    public String editSeller(@PathVariable("sellerId") int sellerId, Map<String, Object> model){

        Seller seller = this.sellerRepository.findSellerById(sellerId);
        model.put("seller", seller);
        return "sellers/addUpdateSellerForm";
    }

    @GetMapping("/sellers/{sellerId}/delete")
    public String deleteSeller(@PathVariable("sellerId") int sellerId){

        this.sellerRepository.deleteById(sellerId);
        return "redirect:/sellers";
    }


}
