package com.pcwonder.api.category;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Category {
    @Id @GeneratedValue private long id;
    private String name;
}
