package com.pcwonder.api.product.motherboard;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Motherboard extends Product {
    private String form;
}
