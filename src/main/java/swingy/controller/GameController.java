package swingy.controller;

import swingy.model.character.Warrior;
import swingy.model.map.SquareMap;
import swingy.view.ui.GameUI;

public class GameController {
    private static GameController instance = null;
    private GameUI gameUI;
    private SquareMap map;
    private Warrior player;

    public GameController(String args)
    {
        this.player = new Warrior();
        this.map = new SquareMap(32);
        GameUI GameUI = new GameUI();
        GameUI.register(player);
        System.out.println(player.toString());
    }

    public static synchronized GameController getInstance(String args) {
        if (instance == null)
            instance = new GameController(args);
        return instance;
    }
}