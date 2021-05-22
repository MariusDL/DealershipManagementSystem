package com.marius.dealershipmanagement.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "key_tag")
    @NotNull
    private int keyTagNumber;

    @Column(name = "make")
    @NotEmpty
    private String make;

    @Column(name = "model")
    @NotEmpty
    private String model;

    @Column(name = "reg")
    @NotEmpty
    private String reg;

    @Column(name = "fabrication_year")
    @NotEmpty
    private String fabrication_year;

    @Column(name = "transmission")
    @NotEmpty
    private String transmission;

    @Column(name = "cc")
    @NotEmpty
    private String cc;

    @Column(name = "colour")
    @NotEmpty
    private String colour;

    @Column(name = "buying_price")
    @NotNull
    private Double buyingPrice;

    @Column(name = "selling_price")
    @NotNull
    private Double sellingPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKeyTagNumber() {
        return keyTagNumber;
    }

    public void setKeyTagNumber(int keyTagNumber) {
        this.keyTagNumber = keyTagNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getFabrication_year() {
        return fabrication_year;
    }

    public void setFabrication_year(String year) {
        this.fabrication_year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
