package com.pcwonder.api.product;

import com.pcwonder.api.category.Category;
import com.pcwonder.api.manufacturer.Manufacturer;
import com.pcwonder.api.product.mouse.Mouse;
import com.pcwonder.api.product.mouse.MouseInterface;
import com.pcwonder.api.product.mouse.Orientation;
import com.pcwonder.api.product.mouse.TrackingMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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
        List<Product> expectedProductList = createDummyProductList();

        when(mockedRepository.findAll()).thenReturn(expectedProductList);

        List<Product> actualProductList = controller.getProducts();
        assertEquals(expectedProductList, actualProductList);
    }

    @Test
    void get_products_with_category_id_returns_empty_list_when_no_products_in_category() {
        List<Product> productList = controller.getProducts(0L);
        assertEquals(0, productList.size());
    }

    @Test
    void get_products_with_category_id_returns_expected_product_list() {
        List<Product> expectedProductList = createDummyProductList();
        long categoryId = expectedProductList.get(0).getCategory().getId();

        when(mockedRepository.findAllByCategoryId(categoryId)).thenReturn(expectedProductList);

        List<Product> actualProductList = controller.getProducts(categoryId);
        assertEquals(expectedProductList, actualProductList);
    }

    @Test
    void get_products_with_category_name_returns_empty_list_when_no_products_in_category() {
        List<Product> productList = controller.getProducts("gpu");
        assertEquals(0, productList.size());
    }

    @Test
    void get_products_with_category_name_returns_expected_product_list() {
        List<Product> expectedProductList = createDummyProductList();
        String categoryName = expectedProductList.get(0).getCategory().getName();

        when(mockedRepository.findAllByCategoryNameIgnoreCase(categoryName)).thenReturn(expectedProductList);

        List<Product> actualProductList = controller.getProducts(categoryName);
        assertEquals(expectedProductList, actualProductList);
    }

    @Test
    void search_products_with_empty_search_string_returns_empty_product_list() {
        List<Product> expectedProductList = new LinkedList<>();
        String searchString = "";

        when(mockedRepository.findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchString, searchString))
                .thenReturn(expectedProductList);

        List<Product> actualProductList = controller.search(searchString);
        assertEquals(expectedProductList, actualProductList);
    }

    @Test
    void search_products_with_valid_search_string_returns_expected_products() {
        List<Product> expectedProductList = createDummyProductList();
        String searchString = "razer";

        when(mockedRepository.findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchString, searchString))
                .thenReturn(expectedProductList);

        List<Product> actualProductList = controller.search(searchString);
        assertEquals(expectedProductList, actualProductList);
    }

    @Test
    void get_product_with_uuid_not_in_repository_throws_product_not_found_exception() {
        assertThrows(ProductNotFoundException.class, () -> controller.getProduct(UUID.randomUUID().toString()));
    }

    @Test
    void get_product_with_uuid_in_repository_returns_expected_product() {
        Product expectedProduct = createDummyProduct();

        when(mockedRepository.findByUuid(expectedProduct.getUuid())).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = controller.getProduct(expectedProduct.getUuid());
        assertEquals(expectedProduct, actualProduct);
    }

    private Product createDummyProduct() {
        Category mouseCategory = new Category();
        mouseCategory.setId(0);
        mouseCategory.setName("Mouse");

        Manufacturer razer = new Manufacturer();
        razer.setId(0);
        razer.setName("Razer");

        Mouse dummyProduct = new Mouse();
        dummyProduct.setId(0);
        dummyProduct.setUuid(UUID.randomUUID().toString());
        dummyProduct.setCategory(mouseCategory);
        dummyProduct.setManufacturer(razer);
        dummyProduct.setName("Deathadder");
        dummyProduct.setDescription("Razer Deathadder is a mouse");
        dummyProduct.setPrice(BigDecimal.valueOf(40.00));
        dummyProduct.setRating(BigDecimal.valueOf(4.5));
        dummyProduct.setYear(2017);
        dummyProduct.setImageURL("");
        dummyProduct.setOrientation(Orientation.RIGHT);
        dummyProduct.setTracking(TrackingMethod.OPTICAL);
        dummyProduct.setButtons(2);
        dummyProduct.setMaxDPI(6400);
        dummyProduct.setWired(true);
        dummyProduct.setMouseInterface(MouseInterface.USB);

        return dummyProduct;
    }

    private List<Product> createDummyProductList() {
        Category mouseCategory = new Category();
        mouseCategory.setId(0);
        mouseCategory.setName("Mouse");

        Manufacturer razer = new Manufacturer();
        razer.setId(0);
        razer.setName("Razer");

        Mouse deathadder = new Mouse();
        deathadder.setId(0);
        deathadder.setUuid(UUID.randomUUID().toString());
        deathadder.setCategory(mouseCategory);
        deathadder.setManufacturer(razer);
        deathadder.setName("Deathadder");
        deathadder.setDescription("Razer Deathadder is a mouse");
        deathadder.setPrice(BigDecimal.valueOf(40.00));
        deathadder.setRating(BigDecimal.valueOf(4.5));
        deathadder.setYear(2017);
        deathadder.setImageURL("");
        deathadder.setOrientation(Orientation.RIGHT);
        deathadder.setTracking(TrackingMethod.OPTICAL);
        deathadder.setButtons(2);
        deathadder.setMaxDPI(6400);
        deathadder.setWired(true);
        deathadder.setMouseInterface(MouseInterface.USB);

        Mouse naga = new Mouse();
        naga.setId(1);
        naga.setUuid(UUID.randomUUID().toString());
        naga.setCategory(mouseCategory);
        naga.setManufacturer(razer);
        naga.setName("Naga");
        naga.setDescription("Razer Naga is a mouse");
        naga.setPrice(BigDecimal.valueOf(40.00));
        naga.setRating(BigDecimal.valueOf(4.0));
        naga.setYear(2014);
        naga.setImageURL("");
        naga.setOrientation(Orientation.RIGHT);
        naga.setTracking(TrackingMethod.OPTICAL);
        naga.setButtons(14);
        naga.setMaxDPI(6400);
        naga.setWired(true);
        naga.setMouseInterface(MouseInterface.USB);

        List<Product> dummyProductList = new LinkedList<>();
        dummyProductList.add(deathadder);
        dummyProductList.add(naga);

        return dummyProductList;
    }
}
