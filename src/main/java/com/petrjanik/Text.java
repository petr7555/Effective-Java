package com.petrjanik;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author Petr Janik 485122
 * @since 06.02.2020
 */
public class Text {
//    public static final int STYLE_BOLD = 1 << 0; // 1
//    public static final int STYLE_ITALIC = 1 << 1; // 2
//    public static final int STYLE_UNDERLINE = 1 << 2; // 4
//    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8
//
//    public void applyStyles(int styles){
//
//    }

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH,}

    public void applyStyles(Set<Style> styles) {

    }
}

class TextDemo {
    public static void main(String[] args) {
        Text text = new Text();
//        text.applyStyles(Text.STYLE_BOLD | Text.STYLE_ITALIC);
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
        EnumSet<Text.Style> set = EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC);
    }
}
