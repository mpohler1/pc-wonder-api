package com.pcwonder.api.product.cpu;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class CPU extends Product {
    private String socket;
    private double speed;
    private int cores;
    private boolean sixtyFourBitSupport;
    private boolean hyperThreadingSupport;
}
