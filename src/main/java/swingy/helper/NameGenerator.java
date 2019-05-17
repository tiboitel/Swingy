package swingy.helper;

import java.util.ArrayList;

public class NameGenerator {
    private static ArrayList<String> syllable = new ArrayList<String>();

    public static String generate()
    {
        int length = Dice.roll(2, 3);
        String name = "";

        syllable.add("vig");
        syllable.add("en");
        syllable.add("to");
        syllable.add("ce");
        syllable.add("he");
        syllable.add("hiel");
        syllable.add("se");
        syllable.add("ri");
        syllable.add("del");
        syllable.add("el");
        syllable.add("ar");
        syllable.add("at");
        syllable.add("hor");
        syllable.add("kh");
        syllable.add("gar");

        for (int i = 0; i < length; i++)
            name += syllable.get(Dice.roll(1, syllable.size() - 1));
        return (name);
    }
}
