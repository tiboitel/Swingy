package swingy.controller;

import swingy.enums.ECharacterClass;
import swingy.helper.CharacterFactory;
import swingy.model.character.Character;
import swingy.model.map.SquareMap;
import swingy.view.ui.GameUI;

import javax.swing.*;

public class GameController {
    private static GameController instance = null;
    private GameUI gameUI;
    private SquareMap map;
    private Character player;

    public GameController()
    {
       player = CharacterFactory.newCharacter(ECharacterClass.DEPRIVED);
       int mapRadius = (4 + 1) * 5 + 10 - (this.player.getLevel() % 2);
       this.map = new SquareMap(mapRadius);
       player.setPosition_x(mapRadius / 2);
       player.setPosition_y(mapRadius / 2);
       map.setPlayer(this.player);
       this.run();

    }

    public static synchronized GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }

    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gameUI = new GameUI();
                player.register(gameUI);
                player.notification();
                map.register(gameUI);
                map.notification();
            }
        });
    }
}