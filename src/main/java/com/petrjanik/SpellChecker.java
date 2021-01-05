package com.petrjanik;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author Petr Janik 485122
 * @since 27/06/2019
 */
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return false;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}
