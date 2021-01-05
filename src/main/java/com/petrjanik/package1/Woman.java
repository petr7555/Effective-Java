package com.petrjanik.package1;

/**
 * @author Petr Janik 485122
 * @since 28/07/2019
 */
class Woman {
    private Car getCar() {
        return new Car();
    }

    private void getInfo() {
        Car car = new Car();
        int windows = car.windowsPackagePrivate;
        int gears = car.gearsProtected;
        int seats = car.seatsPublic;
    }
}
