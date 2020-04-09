package com.pcwonder.api.product.gpu;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class GPU extends Product {
    private int size;
    private double speed;
    private String pciInterface;
    private boolean displayPort;
    private boolean hdmi;
    private boolean dvi;
    private int monitors;
    private int slotWidth;
    private double length;
    private double width;
    private double height;
}
