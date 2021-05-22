package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Client;
import com.marius.dealershipmanagement.models.Vehicle;
import com.marius.dealershipmanagement.repositories.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ClientController {

    private final ClientRepository clientRepository;


    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // return a list with all the clients
    @GetMapping("/clients")
    public String showAllClients(Map<String, Object> model){

        List<Client> clients = clientRepository.findAll();

        model.put("clients", clients);
        model.put("clientToFind", new Client());
        return "/clients/clients";
    }

    // Used to find clients by last name
    // Returns a list with found clients
    @PostMapping("/clients")
    public String findClient(Map<String, Object> model, @ModelAttribute Client clientToFind){
        List<Client> clients = clientRepository.findByLastNameContaining(clientToFind.getLastName());
        model.put("clients",clients);
        model.put("clientToFind", new Client());
        return "clients/clients";
    }

    // Returns the form to add a new vehicle
    @GetMapping("/new-client")
    public String addNewClient(Map<String, Object> model){
        model.put("client", new Client());

        return "clients/addUpdateClientForm";
    }

    // Add new client to database
    @PostMapping("/new-client")
    public String addClient(@Valid Client client, BindingResult result){

        if (result.hasErrors()) {
            return "clients/addUpdateClientForm";
        } else {
            this.clientRepository.save(client);
        }
        return "redirect:/clients";
    }

    @GetMapping("/clients/{clientId}")
    public String editClient(@PathVariable("clientId") int clientId, Map<String, Object> model){

        Client client = this.clientRepository.findClientById(clientId);
        model.put("client", client);
        return "clients/addUpdateClientForm";
    }

    @GetMapping("/clients/{clientId}/delete")
    public String deleteClient(@PathVariable("clientId") int clientId){

        this.clientRepository.deleteById(clientId);
        return "redirect:/clients";
    }








}
