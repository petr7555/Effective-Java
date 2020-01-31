package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 22/08/2019
 */
public class Circle extends Figure {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
