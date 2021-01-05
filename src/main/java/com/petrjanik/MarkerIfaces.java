package com.petrjanik;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.Set;

/**
 * @author Petr Janik 485122
 * @since 10.02.2020
 */

class NowSerializable implements Serializable {

}

interface ParentIface {
    void m1();
}

interface ChildMarkerIface extends ParentIface {
    void m2();
}

class MarkerDemo implements ChildMarkerIface, ParentIface {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(System.out);

//        oos.writeInt(12345);
//        oos.writeObject("Today");
//        oos.writeObject(new Date());
        oos.writeObject(new NowSerializable());

        oos.close();
    }

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }
}
