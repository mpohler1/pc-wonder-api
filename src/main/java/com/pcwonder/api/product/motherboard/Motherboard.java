package com.pcwonder.api.product.motherboard;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Motherboard extends Product {
    private String socket;
    private MotherboardSize size;
    private int maxMemory;
    private int memorySlots;
    private int pciExpress1Slots;
    private int pciExpress2Slots;
    private int pciExpress3Slots;
    private int pciExpress4Slots;
    private int usb2Ports;
    private int usb3Ports;
    private int usbCPorts;
    private int hdmiPorts;
    private int dviPorts;
    private int vgaPorts;
    private int ps2Ports;
}
