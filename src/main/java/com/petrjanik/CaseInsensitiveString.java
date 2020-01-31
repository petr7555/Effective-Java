package com.petrjanik;

import java.util.Objects;

/**
 * @author Petr Janik 485122
 * @since 04/07/2019
 */
public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }

        if (o instanceof String){
            return s.equalsIgnoreCase(((String) o));
        }
        return false;
    }

}
