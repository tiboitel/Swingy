package swingy;

import swingy.controller.GameController;

public class Main {

    public static void main(String[] args) {
        try
        {
            GameController gameController = GameController.getInstance("32");
        } catch (Exception e) {
                 System.out.println("Oups! An error as occured " + e.getStackTrace());
        }
    }
}
