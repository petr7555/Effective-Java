package com.petrjanik.package1;

import java.awt.*;

/**
 * @author Petr Janik 485122
 * @since 28/07/2019
 */
public class Car {
    private int wheelsPrivate = 4;
    int windowsPackagePrivate = 4;
    protected int gearsProtected = 6;
    public int seatsPublic = 4;

    private void fooPrivate() {

    }

    void fooPackagePrivate() {

    }

    protected void fooProtected() {

    }

    public void fooPublic() {

    }
}
