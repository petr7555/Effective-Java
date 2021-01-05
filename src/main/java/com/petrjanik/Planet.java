package com.petrjanik;

import java.math.RoundingMode;

/**
 * @author Petr Janik 485122
 * @since 06.02.2020
 */
public enum Planet {
    MERCURY(3.3e+23, 2.4e6),
    VENUS(4.8e+24, 6.0e6),
    EARTH(5.9e+24, 6.3e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}

class DemoPlanets {
    public static void main(String[] args) {
        double earthWeight = 185;
        double mass = earthWeight/ Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }

    }
}
