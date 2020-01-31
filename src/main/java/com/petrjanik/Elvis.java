package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 27/06/2019
 */
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {

    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {

    }
}