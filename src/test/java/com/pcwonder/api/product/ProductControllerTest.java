package com.pcwonder.api.product;

import com.pcwonder.api.category.Category;
import com.pcwonder.api.manufacturer.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    ProductRepository mockedRepository;

    @InjectMocks
    ProductController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void get_products_returns_empty_list_when_repository_is_empty() {
        List<Product> productList = controller.getProducts();
        assertEquals(0, productList.size());
    }

    @Test
    void get_products_returns_product_list() {
        Category peripheral = new Category();
        peripheral.setId(0);
        peripheral.setName("Peripheral");

        Manufacturer razer = new Manufacturer();
        razer.setId(0);
        razer.setName("Razer");

        Product mouse = new Product();
        mouse.setId(0);
        mouse.setCategory(peripheral);
        mouse.setManufacturer(razer);
        mouse.setName("Deathadder");
        mouse.setPrice(BigDecimal.valueOf(40.00));
        mouse.setRating(BigDecimal.valueOf(4.5));
        mouse.setYear(2017);
        mouse.setImageURL("");

        Product keyboard = new Product();
        keyboard.setId(1);
        keyboard.setCategory(peripheral);
        keyboard.setManufacturer(razer);
        keyboard.setName("Black Widow");
        keyboard.setPrice(BigDecimal.valueOf(150.00));
        keyboard.setRating(BigDecimal.valueOf(4.0));
        keyboard.setYear(2018);
        keyboard.setImageURL("");

        List<Product> expectedProductList = new LinkedList<>();
        expectedProductList.add(mouse);
        expectedProductList.add(keyboard);

        when(mockedRepository.findAll()).thenReturn(expectedProductList);

        List<Product> actualProductList = controller.getProducts();
        assertEquals(expectedProductList, actualProductList);
    }
}
