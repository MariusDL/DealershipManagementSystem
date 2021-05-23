package com.marius.dealershipmanagement.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "vehicle_id")
    @NotNull
    private Integer vehicleId;

    @Column(name = "date_sold")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSold;

    @Column(name = "vehicle_reg")
    @NotEmpty
    private String vehicleReg;

    @Column(name = "vehicle_make")
    @NotEmpty
    private String vehicleMake;

    @Column(name = "vehicle_model")
    @NotEmpty
    private String vehicleModel;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

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

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public void setDateSold(LocalDate dateSold) {
        this.dateSold = dateSold;
    }

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
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

    public void setVehicleDetails(Vehicle vehicle){
        this.setVehicleReg(vehicle.getReg());
        this.setVehicleMake(vehicle.getMake());
        this.setVehicleModel(vehicle.getModel());
        this.setBuyingPrice(vehicle.getBuyingPrice());
        this.setSellingPrice(vehicle.getSellingPrice());
    }
}
