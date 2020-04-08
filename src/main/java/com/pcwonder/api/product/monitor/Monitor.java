package com.pcwonder.api.product.monitor;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Monitor extends Product {
    private double size;
}
