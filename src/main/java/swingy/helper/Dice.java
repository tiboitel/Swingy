package swingy.helper;


import java.util.Random;

public class Dice {
    public static int roll(int dices, int faces)
    {
        Random rand = new Random();
        int number = 0;

        for (int i = 0; i < dices; i++)
        {
            number += rand.nextInt((faces - 1)) + 1;
        }
        return (number);
    }
}
