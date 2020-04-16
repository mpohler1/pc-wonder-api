package com.pcwonder.api.product.gpu;

import com.pcwonder.api.product.Product;
import com.pcwonder.api.product.motherboard.MotherboardSize;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class GPU extends Product {
    private MotherboardSize size;
    private int fans;
    private double speed;
    private String pciInterface;
    private int displayPortPorts;
    private int hdmiPorts;
    private int dviPorts;
    private int slotWidth;
    private double length;
    private double width;
    private double height;
}
