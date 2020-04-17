package com.pcwonder.api.product.storage;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Storage extends Product {
    private StorageType type;
    private FormFactor form;
    private SATAVersion sataVersion;
    private double size;
    private int cache;
}
