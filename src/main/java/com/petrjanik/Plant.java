package com.petrjanik;


import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * @author Petr Janik 485122
 * @since 07.02.2020
 */
public class Plant {

    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL,
    }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}

class PlantDemo {
    public static void main(String[] args) {
        List<Plant> garden = List.of(new Plant("a", Plant.LifeCycle.ANNUAL), new Plant("b", Plant.LifeCycle.PERENNIAL), new Plant("c", Plant.LifeCycle.PERENNIAL));

        Set<Plant>[] plantsByLifeCycleDeprecated = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycleDeprecated.length; i++) {
            plantsByLifeCycleDeprecated[i] = new HashSet<>();
        }

        for (Plant p : garden) {
            plantsByLifeCycleDeprecated[p.lifeCycle.ordinal()].add(p);
        }

        for (int i = 0; i < plantsByLifeCycleDeprecated.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycleDeprecated[i]);
        }

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantsByLifeCycle);

        System.out.println(garden.stream().collect(groupingBy(p -> p.lifeCycle)));

        System.out.println(garden.stream().collect(groupingBy(p -> p.lifeCycle, ()-> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
