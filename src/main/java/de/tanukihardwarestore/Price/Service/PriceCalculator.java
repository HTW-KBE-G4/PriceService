package de.tanukihardwarestore.Price.Service;

import java.util.List;

public class PriceCalculator {

    public static double addPrices(List<HardwareComponent> hardwareComponents) {
            double totalPrice = 0;

            for(HardwareComponent component : hardwareComponents) {
                totalPrice += component.getUvp();
            }

            return Math.round(totalPrice*100D)/100D;
    }
}