package com.petrjanik.package2;

import com.petrjanik.package1.Car;

/**
 * @author Petr Janik 485122
 * @since 28/07/2019
 */
public class Audi extends Car {
    private void getInfo() {
        Audi audi = new Audi();
        int windows =  audi.gearsProtected;
        int seats = audi.seatsPublic;

        audi.fooProtected();
        audi.fooPublic();
    }
}
