package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 15/08/2019
 */
interface Iface {

    default void print(String message){
        System.out.println(message + " from iface");
    }
}
