package com.marius.dealershipmanagement.repositories;

import com.marius.dealershipmanagement.models.Client;
import com.marius.dealershipmanagement.models.Vehicle;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClientRepository extends Repository<Client, Integer> {

    // Return all clients
    List<Client> findAll();

    // Find client by last name
    List<Client> findByLastNameContaining(String name);

    //find client by id
    Client findClientById(Integer id);

    // Add client to database
    void save(Client client);

    // delete client by id
    void deleteById(Integer id);

}
