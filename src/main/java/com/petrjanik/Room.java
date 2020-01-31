//package com.petrjanik;
//
//import sun.misc.Cleaner;
//
///**
// * @author Petr Janik 485122
// * @since 03/07/2019
// */
//public class Room implements AutoCloseable {
//    private static final Cleaner cleaner = Cleaner.create();
//
//    private static class State implements Runnable {
//        int numJunkPiles;
//
//        public State(int numJunkPiles) {
//            this.numJunkPiles = numJunkPiles;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Cleaning room");
//            numJunkPiles = 0;
//        }
//    }
//    private final State state;
//
//    private final Cleaner.Cleanable cleanable;
//
//    @Override
//    public void close() throws Exception {
//        cleanable.close();
//    }
//}
