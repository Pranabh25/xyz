package com.springboot.ecom.controller;

import com.springboot.ecom.model.Manager;
import com.springboot.ecom.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public String listManagers(Model model) {
        List<Manager> managers = managerService.getAllManagers();
        model.addAttribute("managers", managers);
        return "managers"; // Replace with the appropriate JSP view name for managers
    }

    @PostMapping("/add")
    public String addManager(@ModelAttribute Manager manager) {
        managerService.saveManager(manager);
        return "redirect:/managers";
    }

    @GetMapping("/{id}")
    public String getManagerById(@PathVariable int id, Model model) {
        model.addAttribute("manager", managerService.getManagerById(id).orElse(null));
        return "manager-details"; // Replace with the appropriate JSP view for manager details
    }

    @PostMapping("/delete/{id}")
    public String deleteManager(@PathVariable int id) {
        managerService.deleteManager(id);
        return "redirect:/managers";
    }
}
