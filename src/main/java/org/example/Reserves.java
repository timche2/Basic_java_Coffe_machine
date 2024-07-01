package org.example;

public enum Reserves {

    ESPRESSO(0.1, 0.05, 0.1),
    CAPUCHINO(0.15, 0.06,0.15 );
    private double water;
    private double coffee;
    private double milk;

    Reserves(double water, double coffee, double milk) {
        this.water = water;
        this.coffee = coffee;
        this.milk = milk;
    }

    public double getWater() {
        return water;
    }

    public double getCoffee() {
        return coffee;
    }

    public double getMilk() {
        return milk;
    }
}
