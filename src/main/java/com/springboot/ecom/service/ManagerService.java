package com.springboot.ecom.service;

import com.springboot.ecom.model.Manager;
import com.springboot.ecom.repository.ManagerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(int id) {
        return managerRepository.findById(id);
    }

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public void deleteManager(int id) {
        managerRepository.deleteById(id);
    }
}

