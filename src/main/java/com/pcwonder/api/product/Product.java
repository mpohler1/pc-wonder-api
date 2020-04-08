package com.pcwonder.api.product;

import com.pcwonder.api.category.Category;
import com.pcwonder.api.manufacturer.Manufacturer;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturer;

    private String name;
    private int year;
    private BigDecimal price;
    private BigDecimal rating;
    private String imageURL;
}
