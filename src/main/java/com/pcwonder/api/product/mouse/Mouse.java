package com.pcwonder.api.product.mouse;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Mouse extends Product {
    private Orientation orientation;
    private TrackingMethod tracking;
    private boolean wired;
    private MouseInterface mouseInterface;
    private int buttons;
    private int maxDPI;
}
