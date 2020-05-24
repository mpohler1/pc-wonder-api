package com.pcwonder.api.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufacturerController {

    private ManufacturerRepository repository;

    @Autowired
    public ManufacturerController(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin("*")
    @GetMapping("/manufacturers")
    List<Manufacturer> getManufacturers() {
        return repository.findAllByOrderByNameAsc();
    }
}
