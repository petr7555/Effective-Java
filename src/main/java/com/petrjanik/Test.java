package com.petrjanik;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Indicates, that the annotated method is a test method.
 * Use only on parameterless static methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

class Sample {
    @Test
    public static void m1() {
    } // should pass

    public static void m2() {
    }

    @Test
    public static void m3() { // should fail
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public void m5() {
    } //invalid use: nonstatic method

    public static void m6() {
    }

    @Test
    public static void m7() { // should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }
}

///**
// * Indicates, that the annotated method is a test method
// * that must throw the designated exception to succeed.
// */
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//@interface ExceptionTest {
//    Class<? extends Throwable>[] value();
//}

/**
 * // * Indicates, that the annotated method is a test method
 * // * that must throw the designated exception to succeed.
 * //
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
@interface ExceptionTest {
    Class<? extends Throwable> value();
}

/**
 * // * Indicates, that the annotated method is a test method
 * // * that must throw the designated exception to succeed.
 * //
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTestContainer {
    ExceptionTest[] value();
}

class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // Test should pass
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() { // Should fail (no exception)
    }

    //    @ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() { // Should pass
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }

    //     @ExceptionTest({IndexOutOfBoundsException.class, NullPointerException.class})
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void m4() { // Should fail (different exception)
        int i = 0;
        i = i / i;
    }
}


class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.petrjanik.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class) ||m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTest[] excTests = m.getAnnotationsByType(ExceptionTest.class);
                    for (ExceptionTest excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (oldPassed == passed) {
                        System.out.printf("Test %s failed: %s%n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @ExceptionTest: " + m);
                }
            }
        }
        System.out.printf("Passed %d, Failed: %d%n", passed, tests - passed);
    }
}
