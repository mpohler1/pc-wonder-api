package com.pcwonder.api.product;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
@SecondaryTable(name = "category")
public class Product {

    private @Id @GeneratedValue long id;
    private String name;
    private String description;
    private BigDecimal price;
    private double rating;

    @Column(table = "category", name = "id")
    private long categoryID;

    @Column(table = "category", name = "name")
    private String categoryName;
}
