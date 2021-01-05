package com.petrjanik;

import com.sun.source.tree.Tree;
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Petr Janik 485122
 * @since 16.02.2020
 */
class MyClass {

    public void execute(Runnable command) {
    }

    public void doSomething0(Function<String, Integer> function) {

    }

    public void doSomething(Function<Object, Object> function) {

    }

    public void doSomething2(Function<Instant, Boolean> function) {

    }

    public void doSomething3(Function<String, String> function) {

    }


    public void doSomething4(Function<Integer, int[]> aNew) {

    }
}

public class MethodReference {
    static Integer sumIt(Integer a, Integer b) {
        return a + b;
    }

    static void action() {
    }

    void nonStatic() {

    }

    public static <K, V> void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String key = "first";
        map.merge(key, 1, Integer::sum);
        map.merge(key, 1, MethodReference::sumIt);
        System.out.println(map);

        MyClass service = new MyClass();
        service.execute(MethodReference::action);
        MethodReference methodReference = new MethodReference();
        service.execute(methodReference::nonStatic);
        service.execute(new MethodReference()::nonStatic);
        service.doSomething(Function.identity());
        service.doSomething(x -> x);
        service.doSomething0(Integer::parseInt);
        service.doSomething2(Instant.now()::isAfter);
        service.doSomething3(String::toLowerCase);
        service.doSomething4(int[]::new);
    }
}
