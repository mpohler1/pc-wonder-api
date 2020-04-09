package com.pcwonder.api.product.psu;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class PSU extends Product {
    private int maxPower;
    private EnergyEfficiency efficiency;
    private int lifespan;
    private int atxConnectors;
    private int epsConnectors;
    private int pciConnectors;
    private int sataConnectors;
    private int peripheralConnectors;
    private int floppyConnectors;
    private double length;
    private double width;
    private double height;
    private double weight;
}
