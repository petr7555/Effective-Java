package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 10.02.2020
 */
interface Pettable {
    void pet();
    void beAmazed(Object o);
    default void beAmazed() {
        System.out.println("Awwww!");
    }
}

interface SubPettable extends Pettable {
    @Override
    void pet();
}
