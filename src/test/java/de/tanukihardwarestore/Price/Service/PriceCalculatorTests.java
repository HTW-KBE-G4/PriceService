package de.tanukihardwarestore.Price.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class PriceCalculatorTests {

    @Test
    public void AddPricesTestCase1() {
        List<HardwareComponent> components = new LinkedList<>();

        components.add(new HardwareComponent(5552.09F));
        components.add(new HardwareComponent(1300.00F));
        components.add(new HardwareComponent(77.96F));
        components.add(new HardwareComponent(406.95F));
        components.add(new HardwareComponent(96.00F));
        components.add(new HardwareComponent(73.87F));

        double res = PriceCalculator.addPrices(components);

        assertEquals(7506.87,res);

    }

    @Test
    public void AddPricesTestCase2() {
        List<HardwareComponent> components = new LinkedList<>();

        components.add(new HardwareComponent(5552.09F));
        components.add(new HardwareComponent(142.78F));
        components.add(new HardwareComponent(77.96F));
        components.add(new HardwareComponent(87.68F));
        components.add(new HardwareComponent(96.00F));
        components.add(new HardwareComponent(73.87F));

        double res = PriceCalculator.addPrices(components);

        assertEquals(6030.38,res);

    }

    @Test
    public void TestEmptyList() {
        List<HardwareComponent> components = new LinkedList<>();

        double res = PriceCalculator.addPrices(components);

        assertEquals(0,res);

    }
}
