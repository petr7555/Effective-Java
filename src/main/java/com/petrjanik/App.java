package com.petrjanik;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.*;

import static com.petrjanik.Rank.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Apple.Seed seed = new Apple.Seed();
        Apple apple = new Apple();
        Apple.Skin skin = apple.new Skin();
        new IfaceImpl().print("Hello");
        List<Integer> integers = Skeletal.intArrayAsList(new int[]{1, 2, 3});
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(set.getAddCount());
        Hour hour = new Hour(4);
        Time time = new Time(hour, 5);
        hour.value = 7;
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.push(5);
        try (BufferedReader br = new BufferedReader(new FileReader(""))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("default");
        }

        System.runFinalization();
        int bitLength = 4; // 512 bits
        SecureRandom rnd = new SecureRandom();
        int certainty = 500; // 1 - 1/2(90) certainty
        System.out.println("BitLength : " + bitLength);
        BigInteger mod = new BigInteger(bitLength, certainty, rnd);
        BigInteger exponent = BigInteger.probablePrime(bitLength, rnd);
        BigInteger n = BigInteger.probablePrime(bitLength, rnd);

        BigInteger result = n.modPow(exponent, mod);
        System.out.println("Number ^ Exponent MOD Modulus = Result");
        System.out.println("Number");
        System.out.println(n);
        System.out.println("Exponent");
        System.out.println(exponent);
        System.out.println("Modulus");
        System.out.println(mod);
        System.out.println("Result");
        System.out.println(result);

        Date from = Date.from(Instant.now());
        Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
        BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
        Object newArray = Array.newInstance(Person.class, 4);
        try {
            Path path = Paths.get(App.class.getClassLoader().getResource("file.txt").toURI());
            FileStore fs = Files.getFileStore(path);
            BufferedReader br = Files.newBufferedReader(path);
            System.out.println("debug break");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Vector v = new Vector();
        v.add("A");
        v.add("B");
        v.add("C");
        v.elements();
        List list = Collections.list(v.elements());
    }
}
