package com.petrjanik;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @author Petr Janik 485122
 * @since 29/01/2020
 */
public class DemoGeneric {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <E extends Comparable<? super E>> E max(Collection<? extends E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }
        String max = max(Arrays.asList("jute", "hemp", "nylon"));
        System.out.println(max);


        Set<Integer> integers = new HashSet<>(Arrays.asList(1, 3, 5));
        Set<Double> doubles = new HashSet<>(Arrays.asList(2.0, 4.0, 6.0));
        Set<Number> numbers = union(integers, doubles);
        System.out.println(numbers);
    }
}




