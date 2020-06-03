package com.pcwonder.api.category;

import com.pcwonder.api.manufacturer.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CategoryControllerTest {

    @Mock
    CategoryRepository mockedRepository;

    @InjectMocks
    CategoryController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void get_categories_returns_an_empty_list_when_repository_is_empty() {
        List<Category> categoryList = controller.getCategories();
        assertEquals(0, categoryList.size());
    }

    @Test
    void get_categories_returns_categories_sorted_by_name_asc() {
        List<Category> expectedCategoryList = makeDummyCategoryList();

        when(mockedRepository.findAllByOrderByNameAsc()).thenReturn(expectedCategoryList);

        List<Category> actualCategoryList = controller.getCategories();
        assertEquals(expectedCategoryList, actualCategoryList);
    }

    private List<Category> makeDummyCategoryList() {
        List<Manufacturer> dummyCPUManufacturerList = makeDummyCPUManufacturerList();
        List<Manufacturer> dummyGPUManufacturerList = makeDummyGPUManufacturerList();

        Category cpu = new Category();
        cpu.setId(0);
        cpu.setName("CPU");
        cpu.setManufacturers(dummyCPUManufacturerList);

        Category gpu = new Category();
        gpu.setId(1);
        gpu.setName("GPU");
        gpu.setManufacturers(dummyGPUManufacturerList);

        List<Category> dummyCategoryList = new LinkedList<>();
        dummyCategoryList.add(gpu);
        dummyCategoryList.add(cpu);
        return dummyCategoryList;
    }

    private List<Manufacturer> makeDummyCPUManufacturerList() {
        Manufacturer intel = new Manufacturer();
        intel.setId(0);
        intel.setName("Intel");

        Manufacturer amd = new Manufacturer();
        amd.setId(1);
        amd.setName("AMD");

        LinkedList<Manufacturer> dummyCPUManufacturerList = new LinkedList<>();
        dummyCPUManufacturerList.add(intel);
        dummyCPUManufacturerList.add(amd);
        return dummyCPUManufacturerList;
    }

    private List<Manufacturer> makeDummyGPUManufacturerList() {
        Manufacturer amd = new Manufacturer();
        amd.setId(1);
        amd.setName("AMD");

        Manufacturer nvidia = new Manufacturer();
        nvidia.setId(2);
        nvidia.setName("Nvidia");

        LinkedList<Manufacturer> dummyGPUManufacturerList = new LinkedList<>();
        dummyGPUManufacturerList.add(amd);
        dummyGPUManufacturerList.add(nvidia);
        return dummyGPUManufacturerList;
    }
}
