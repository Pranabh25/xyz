package com.springboot.ecom.controller;

import com.springboot.ecom.model.Delivery;
import com.springboot.ecom.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public String listDeliveries(Model model) {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);
        return "deliveries"; // Replace with the appropriate JSP view name for deliveries
    }

    @PostMapping("/add")
    public String addDelivery(@ModelAttribute Delivery delivery) {
        deliveryService.saveDelivery(delivery);
        return "redirect:/deliveries";
    }

    @GetMapping("/{id}")
    public String getDeliveryById(@PathVariable int id, Model model) {
        model.addAttribute("delivery", deliveryService.getDeliveryById(id).orElse(null));
        return "delivery-details"; // Replace with the appropriate JSP view for delivery details
    }

    @PostMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable int id) {
        deliveryService.deleteDelivery(id);
        return "redirect:/deliveries";
    }
}
