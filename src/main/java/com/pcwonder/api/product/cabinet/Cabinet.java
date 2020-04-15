package com.pcwonder.api.product.cabinet;

import com.pcwonder.api.product.Product;
import com.pcwonder.api.product.motherboard.MotherboardSize;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Cabinet extends Product {
    private MotherboardSize size;
    private double maxPSULength;
    private int largeHDDBays;
    private int smallHDDBays;
    private String color;
    private double length;
    private double width;
    private double height;
    private double weight;
}
