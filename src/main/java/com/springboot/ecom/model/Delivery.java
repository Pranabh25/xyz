package com.springboot.ecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Delivery {

    @Id
    private int id;

    @Column(nullable = false)
    private String deliveryPerson;

    @Column(nullable = false)
    private Timestamp deliveryDatetime;

    private String proof;

    private String specialInstruction;

    @Column(nullable = false)
    private Timestamp pickupTime;

    @Column(nullable = false)
    private int shipmentId;

    @Column(nullable = false)
    private int orderId;

    @Column(nullable = false)
    private int warehouseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(String deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public Timestamp getDeliveryDatetime() {
        return deliveryDatetime;
    }

    public void setDeliveryDatetime(Timestamp deliveryDatetime) {
        this.deliveryDatetime = deliveryDatetime;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public Timestamp getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Timestamp pickupTime) {
        this.pickupTime = pickupTime;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }
}
