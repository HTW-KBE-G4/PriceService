package de.tanukihardwarestore.Price.Service;

import java.io.Serializable;

public class Result implements Serializable {

    public double total;

    public Result(double total) {
        this.total = total;
    }

    public Result() {}

    public double getTotal() {
        return total;
    }
}
