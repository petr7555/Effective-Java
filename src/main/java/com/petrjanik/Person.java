package com.petrjanik;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparingInt;

/**
 * @author Petr Janik 485122
 * @since 23/06/2019
 */
public class Person implements AutoCloseable {

    String name;
    int age;

    @Override
    final protected void finalize() throws Throwable {
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public Person clone() {
//        return (Person) super.clone();
//    }
//
//    private static final Comparator<Person> COMPARATOR = comparingInt((Person p
//    ) -> p.age).thenComparing(p -> p.name);
//    Integer.compare
}
