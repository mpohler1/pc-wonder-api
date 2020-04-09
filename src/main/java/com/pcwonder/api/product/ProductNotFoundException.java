package com.pcwonder.api.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class ProductNotFoundException extends RuntimeException {

    ProductNotFoundException(String uuid) {
        super("Product with UUID " + uuid + " not found");
    }
}
