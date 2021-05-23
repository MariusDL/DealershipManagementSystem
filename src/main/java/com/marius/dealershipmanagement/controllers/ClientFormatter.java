package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Client;
import com.marius.dealershipmanagement.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Controller
public class ClientFormatter implements Formatter<Client> {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientFormatter(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}


	@Override
	public Client parse(String text, Locale locale) throws ParseException {
		Collection<Client> findClients = this.clientRepository.findAll();
		for (Client client : findClients) {
			String clientName = client.getFirstName() + " " + client.getLastName();
			if (clientName.equals(text)) {
				return client;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}

	@Override
	public String print(Client client, Locale locale) {
		return client.getFirstName() + " " + client.getLastName();
	}
}
