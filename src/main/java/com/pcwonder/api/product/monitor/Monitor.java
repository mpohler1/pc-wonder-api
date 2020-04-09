package com.pcwonder.api.product.monitor;

import com.pcwonder.api.product.Product;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Monitor extends Product {
    private double size;
    private int resolutionX;
    private int resolutionY;
    private int refreshRate;
    private int responseTime;
    private boolean speakers;
    private boolean curved;
    private boolean displayPort;
    private boolean hdmi;
    private int usbPorts;
}
