package com.pcwonder.api.category;

import com.pcwonder.api.manufacturer.Manufacturer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "category_manufacturer",
            joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "manufacturer_id", referencedColumnName = "id", nullable = false)}
    )
    @OrderBy("name ASC")
    private List<Manufacturer> manufacturers;

    private String name;
}
