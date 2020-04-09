package com.pcwonder.api.product.memory;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Memory extends Product {
    private int size;
    private int numSticks;
    private int memoryPerStick;
    private MemoryType type;
}
