package swingy;

import swingy.controller.CharacterCreationController;
import swingy.controller.GameController;

public class Main {

    public static void usage()
    {
        System.out.println("Usage: java -jar swingy.jar [console | gui]");
    }

    public static void main(String[] args) {
        try
        {
            /*if (args.length != 1) {
                usage();
                System.exit(-1);
            }*/
            CharacterCreationController characterCreationController = CharacterCreationController.getInstance();
            characterCreationController.CreateNewCharacter(2);
            GameController gameController = GameController.getInstance();

        } catch (Exception e) {
                 System.out.println("Oups! An error as occured " + e.getMessage());
        }
    }
}
