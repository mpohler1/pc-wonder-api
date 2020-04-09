package com.pcwonder.api.product.keyboard;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Keyboard extends Product {
    private KeyboardSize size;
    private boolean mechanical;
    private boolean backLit;
    private boolean wired;
    private boolean usb;
    private boolean ps2;
    private String color;
}
