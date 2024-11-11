package com.springboot.ecom.controller;

import com.springboot.ecom.model.Shipment;
import com.springboot.ecom.service.ShipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    public String listShipments(Model model) {
        List<Shipment> shipments = shipmentService.getAllShipments();
        model.addAttribute("shipments", shipments);
        return "shipments"; // Replace with the appropriate JSP view name for shipments
    }

    @PostMapping("/add")
    public String addShipment(@ModelAttribute Shipment shipment) {
        shipmentService.saveShipment(shipment);
        return "redirect:/shipments";
    }

    @GetMapping("/{id}")
    public String getShipmentById(@PathVariable int id, Model model) {
        model.addAttribute("shipment", shipmentService.getShipmentById(id).orElse(null));
        return "shipment-details"; // Replace with the appropriate JSP view for shipment details
    }

    @PostMapping("/delete/{id}")
    public String deleteShipment(@PathVariable int id) {
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";
    }
}
