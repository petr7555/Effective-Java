package com.petrjanik;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * @author Petr Janik 485122
 * @since 07.02.2020
 */

public enum Phase {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT, IONIZE, DEIONIZE;

        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME, null},
                {FREEZE, null, BOIL, null},
                {DEPOSIT, CONDENSE, null, IONIZE},
                {null, null, DEIONIZE, null}
        };

        public static Transition from(Phase from, Phase to){
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
//public enum Phase {
//    SOLID, LIQUID, GAS, PLASMA;
//
//    public enum Transition {
//        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
//        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
//        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
//        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);
//
//        private final Phase from;
//        private final Phase to;
//
//        Transition(Phase from, Phase to) {
//            this.from = from;
//            this.to = to;
//        }
//
//        private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values()).collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class), toMap(t -> t.to, t->t, (x,y) -> y, ()-> new EnumMap<>(Phase.class))));
//
//        public static Transition from(Phase from, Phase to) {
//            return m.get(from).get(to);
//        }
//
//        public static Map<Phase, Map<Phase, Transition>> getM() {
//            return m;
//        }
//    }
//}

class PhaseDemo{
    public static void main(String[] args) {
//        Map<Phase, Map<Phase, Phase.Transition>> m = Phase.Transition.getM();
//        System.out.println(m);

        Phase.Transition transition = Phase.Transition.from(Phase.GAS, Phase.PLASMA);
        Phase.Transition transition2 = Phase.Transition.from(Phase.PLASMA, Phase.GAS);
        System.out.println(transition);
        System.out.println(transition2);

    }
}
