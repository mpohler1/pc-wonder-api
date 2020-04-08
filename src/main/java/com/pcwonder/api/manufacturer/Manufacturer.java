package com.pcwonder.api.manufacturer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Manufacturer {

    @Id @GeneratedValue private long id;
    private String name;
}
