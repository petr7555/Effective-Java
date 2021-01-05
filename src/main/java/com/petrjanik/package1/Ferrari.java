package com.petrjanik.package1;

/**
 * @author Petr Janik 485122
 * @since 28/07/2019
 */
public class Ferrari extends Car {
    private void getInfo() {
        Car car = new Car();
        int windows = car.windowsPackagePrivate;
        int gears = car.gearsProtected;
        int seats = car.seatsPublic;

        car.fooPackagePrivate();
        car.fooProtected();
        car.fooPublic();
    }
}
