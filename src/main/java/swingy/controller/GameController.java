package swingy.controller;

import swingy.enums.ECharacterClass;
import swingy.helper.CharacterFactory;
import swingy.model.character.Character;
import swingy.model.character.Monster;
import swingy.model.map.SquareMap;
import swingy.view.ui.GameUI;

import javax.swing.*;
import java.util.LinkedList;

public class GameController {
    private static GameController instance = null;
    private GameUI gameUI;
    private SquareMap map;
    private Character player;
    private LinkedList<Monster> monsters;

    public GameController()
    {
        // Need to be load from the previous controller.
       player = CharacterFactory.newCharacter(ECharacterClass.DEPRIVED);
       int mapRadius = (player.getLevel() - 1) * 5 + 10 - (this.player.getLevel() % 2);
       this.map = new SquareMap(mapRadius);
       player.setPosition_x(mapRadius / 2);
       player.setPosition_y(mapRadius / 2);
       // Need to generate monsters
       map.setPlayer(this.player);
       map.setMonsters(this.monsters);
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
                gameUI.getMoveButton().addActionListener(e->
                {
                    playerMove(gameUI.getCharacterDirection());
                });
                player.register(gameUI);
                map.register(gameUI);
                player.notification();
                map.notification();
            }
        });
    }

    private function playerMove(String direction)
    {
        System.out.println("Direction: " + direction);
        player.setPosition_x(player.getPosition_x() + 1);
    }
}