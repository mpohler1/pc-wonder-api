package com.pcwonder.api.manufacturer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ManufacturerControllerTest {

    @Mock
    ManufacturerRepository mockedRepository;

    @InjectMocks
    ManufacturerController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void get_manufacturers_returns_an_empty_list_when_repository_is_empty() {
        List<Manufacturer> manufacturerList = controller.getManufacturers();
        assertEquals(0, manufacturerList.size());
    }

    @Test
    void get_manufacturers_returns_manufacturers_sorted_by_name_asc() {
        Manufacturer intel = new Manufacturer();
        intel.setId(0);
        intel.setName("Intel");

        Manufacturer nvidia = new Manufacturer();
        nvidia.setId(1);
        nvidia.setName("Nvidia");

        List<Manufacturer> expectedManufacturerList = new LinkedList<>();
        expectedManufacturerList.add(intel);
        expectedManufacturerList.add(nvidia);

        when(mockedRepository.findAllByOrderByNameAsc()).thenReturn(expectedManufacturerList);

        List<Manufacturer> actualManufacturerList = controller.getManufacturers();
        assertEquals(expectedManufacturerList, actualManufacturerList);
    }
}
