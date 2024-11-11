package com.springboot.ecom.controller;

import com.springboot.ecom.model.Warehouse;
import com.springboot.ecom.service.WarehouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public String listWarehouses(Model model) {
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        model.addAttribute("warehouses", warehouses);
        return "warehouses"; // Replace with the appropriate JSP view name for warehouses
    }

    @PostMapping("/add")
    public String addWarehouse(@ModelAttribute Warehouse warehouse) {
        warehouseService.saveWarehouse(warehouse);
        return "redirect:/warehouses";
    }

    @GetMapping("/{id}")
    public String getWarehouseById(@PathVariable int id, Model model) {
        model.addAttribute("warehouse", warehouseService.getWarehouseById(id).orElse(null));
        return "warehouse-details"; // Replace with the appropriate JSP view for warehouse details
    }

    @PostMapping("/delete/{id}")
    public String deleteWarehouse(@PathVariable int id) {
        warehouseService.deleteWarehouse(id);
        return "redirect:/warehouses";
    }
}
