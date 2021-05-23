package com.marius.dealershipmanagement.controllers;

import com.marius.dealershipmanagement.models.Client;
import com.marius.dealershipmanagement.models.Seller;
import com.marius.dealershipmanagement.repositories.ClientRepository;
import com.marius.dealershipmanagement.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Controller
public class SellerFormatter implements Formatter<Seller> {

	private final SellerRepository sellerRepository;

	@Autowired
	public SellerFormatter(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}


	@Override
	public Seller parse(String text, Locale locale) throws ParseException {
		Collection<Seller> findSellers = this.sellerRepository.findAll();
		for (Seller seller : findSellers) {
			String sellerName = seller.getFirstName() + " " + seller.getLastName();
			if (sellerName.equals(text)) {
				return seller;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}


	@Override
	public String print(Seller seller, Locale locale) {
		return seller.getFirstName() + " " + seller.getLastName();	}
}
