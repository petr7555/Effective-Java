package com.petrjanik;

import java.util.List;

/**
 * @author Petr Janik 485122
 * @since 22/08/2019
 */
public class Apple {
    private List<Seed> seeds;
    private static String color;

    public Apple(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public Apple() {
        Seed seed = new Seed();
        Skin skin = new Skin();

    }

    public static class Seed {
    }
    public class Skin {
    }
}
