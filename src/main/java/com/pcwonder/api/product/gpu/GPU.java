package com.pcwonder.api.product.gpu;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class GPU extends Product {
    private int ram;
    private double speed;
    private double length;
    private double width;
    private double height;
}
