package com.pcwonder.api.category;

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
        Category cpu = new Category();
        cpu.setId(0);
        cpu.setName("CPU");

        Category gpu = new Category();
        gpu.setId(1);
        gpu.setName("GPU");

        List<Category> expectedCategoryList = new LinkedList<>();
        expectedCategoryList.add(gpu);
        expectedCategoryList.add(cpu);

        when(mockedRepository.findAllByOrderByNameAsc()).thenReturn(expectedCategoryList);

        List<Category> actualCategoryList = controller.getCategories();
        assertEquals(expectedCategoryList, actualCategoryList);
    }
}
