package com.pcwonder.api.product.psu;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class PSU extends Product {
    private int wattage;
    private double length;
    private double width;
    private double height;
}
