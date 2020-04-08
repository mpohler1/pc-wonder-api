package com.pcwonder.api.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findAllByOrderByNameAsc();
}
