package com.petrjanik;

import java.nio.file.CopyOption;
import java.nio.file.LinkOption;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * @author Petr Janik 485122
 * @since 08.02.2020
 */
public interface OperationInf {
    double apply(double x, double y);
}

enum BasicOperation implements OperationInf {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

enum ExtendedOperation implements OperationInf {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

class DemoOperation {
    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        test(ExtendedOperation.class, x, y);
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
//        List<OperationInf> extendedOps = Arrays.asList(ExtendedOperation.values());
//        List<OperationInf> basicOps = Arrays.asList(BasicOperation.values());
//        List<OperationInf> newList = new ArrayList<>(extendedOps);
//        newList.addAll(basicOps);
//        test2(newList, x, y);
    }

    private static <T extends Enum<T> & OperationInf> void test(Class<T> opEnumType, double x, double y) {
        for (OperationInf op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void test2(Collection<? extends OperationInf> opSet, double x, double y) {
        for (OperationInf op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
