package com.pcwonder.api.product.desktopcase;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class DesktopCase extends Product {
    private double length;
    private double width;
    private double height;
    private double weight;
}
