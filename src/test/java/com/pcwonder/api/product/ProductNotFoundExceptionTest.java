package com.pcwonder.api.product;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductNotFoundExceptionTest {

    @Test
    void product_not_found_exception_contains_expected_message() {
        String uuid = UUID.randomUUID().toString();
        String expectedMessage = "Product with UUID " + uuid + " not found";
        assertEquals(expectedMessage, new ProductNotFoundException(uuid).getMessage());
    }
}
