package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 10.02.2020
 */
abstract class AbstractClass {
    abstract void m1();

    void m2() {
        System.out.println("not abstract");
    }
}


class AbstractClassImpl extends AbstractClass {
    @Override
    void m1() {

    }
}
