package com.petrjanik;

/**
 * @author Petr Janik 485122
 * @since 09/08/2019
 */
public interface SingerSongwriter extends Singer, Songwriter {
    AudioClip strum();

    default void actSensitive(){
        System.out.println("acting");
    }

    default Song compose(int chartPosition) {
        return new Song();
    }

}