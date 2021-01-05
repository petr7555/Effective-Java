package com.petrjanik;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Petr Janik 485122
 * @since 05.02.2020
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalArgumentException();
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }
}

class DemoFavorites {
    public static void main(String[] args) {
        HashSet set = new HashSet<Integer>();
        set.add("dsf");
        for (Object o : set) {
            String s = (String) o;
            System.out.println(s);
        }
        Favorites f = new Favorites(

        );
        Class stringClass = String.class;
        f.putFavorite(stringClass, "Java");
        Class integerClass = Integer.class;
        f.putFavorite(integerClass, 1);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

        Class<String> sClass = String.class;
        Class<?> iClass = Integer.class;
//        sClass.getAnnotation((Class<? extends Annotation>) iClass);
//        sClass.getAnnotation(iClass.asSubclass(Annotation.class));
        Annotation annotation1 = Integer.class.getAnnotation(SafeVarargs.class.asSubclass(Annotation.class));
        System.out.println(annotation1);

        Annotation annotation = Favorites.getAnnotation(Integer.class, "SafeVarargs");
        System.out.println(annotation);
    }
}
