package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 03/08/2019
 */
public class Complex2 {
    private final double re;
    private final double im;

    private Complex2(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex2 valueOf(double re, double im) {
        return new Complex2(re, im);
    }
}
