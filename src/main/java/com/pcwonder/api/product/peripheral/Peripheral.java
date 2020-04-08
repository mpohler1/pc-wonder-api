package com.pcwonder.api.product.peripheral;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Peripheral extends Product {
    private boolean wired;
}
