package com.pcwonder.api.product.motherboard;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Motherboard extends Product {
    private String socket;
    private MotherboardSize size;
    private int memorySlots;
    private int maxMemory;
    private int pciExpress2Slots;
    private int pciExpress3Slots;
    private int usb2Slots;
    private int usb3slots;
    private int usbCSlots;
    private int hdmiSlots;
    private int ps2Slots;
}
