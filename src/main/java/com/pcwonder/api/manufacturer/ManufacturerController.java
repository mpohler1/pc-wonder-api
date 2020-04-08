package com.pcwonder.api.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ManufacturerController {

    private ManufacturerRepository repository;

    @Autowired
    public ManufacturerController(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/manufacturers")
    public List<Manufacturer> getManufacturers() {
        return repository.findAllOrderByNameAsc();
    }
}
