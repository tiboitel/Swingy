package swingy.controller;

import swingy.enums.ECharacterClass;
import swingy.helper.CharacterFactory;
import swingy.helper.Dice;
import swingy.helper.Logger;
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
    private Logger logger = Logger.getLogger();
    private LinkedList<Monster> monsters = new LinkedList<>();

    public GameController()
    {
        // Need to be load from the previous controller.
       player = CharacterFactory.newCharacter(ECharacterClass.DEPRIVED);
       this.generateLevel();
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
                logger.setMode('g');
                gameUI = new GameUI();
                gameUI.getMoveButton().addActionListener(e->
                {
                    playerMove(gameUI.getCharacterDirection().getModel().getSelectedItem().toString());
                });
                gameUI.getRunButton().addActionListener(e->
                {
                    playerRun();
                });
                gameUI.getFightButton().addActionListener(e->
                {
                    playerFight();
                });
                logger.setTextArea(gameUI.getChatTextPane());
                player.register(gameUI);
                player.notification();
                map.register(gameUI);
                map.notification();
                gameUI.getFightButton().setEnabled(false);
                gameUI.getRunButton().setEnabled(false);
            }
        });
    }

    private void generateLevel() {
        int mapRadius = (player.getLevel() - 1) * 5 + 10 - (this.player.getLevel() % 2);
        this.map = new SquareMap(mapRadius);

        player.setPosition_x(mapRadius / 2);
        player.setPosition_y(mapRadius / 2);

        monsters.clear();
        Monster goblin = new Monster();
        goblin.setPosition_x(2);
        goblin.setPosition_y(2);
        monsters.add(goblin);

        map.setPlayer(player);
        map.setMonsters(monsters);
        if (gameUI != null)
        {
            map.register(gameUI);
            gameUI.getFightButton().setEnabled(false);
            gameUI.getRunButton().setEnabled(false);
        }
    }

    private void playerMove(String direction)
    {
        int playerX = player.getPosition_x();
        int playerY = player.getPosition_y();

        player.setPreviousPositionX(playerX);
        player.setPreviousPositionY(playerY);
        switch (direction) {
            case "North":
                player.setPosition_y(playerY - 1);
                break;
            case "South":
                player.setPosition_y(playerY + 1);
                break;
            case "East":
                player.setPosition_x(playerX - 1);
                break;
            case "West":
                player.setPosition_x(playerX + 1);
                break;
        }
        for (Monster monster : monsters)
        {
            if (monster.getPosition_x() == player.getPosition_x() &&
                    monster.getPosition_y() == player.getPosition_y())
            {
                gameUI.getMoveButton().setEnabled(false);
                gameUI.getFightButton().setEnabled(true);
                gameUI.getRunButton().setEnabled(true);
            }
        }
        if (isOutsideBorderOfMap(player))
        {
            logger.log("You have beaten the level !");
            this.generateLevel();
        }
        map.notification();
    }

    private void playerFight()
    {
        Monster ennemy = null;
        int damage = 0;

        for (Monster monster : monsters)
        {
            if (monster.getPosition_x() == player.getPosition_x() &&
                monster.getPosition_y() == player.getPosition_y())
                ennemy = monster;
        }
        if (ennemy == null)
            return ;
        while (player.getHealthpoint() > 0 && ennemy.getHealthpoint() > 0) {
            damage = player.attack(ennemy);
            if (damage > 0)
                logger.log("You have inflicted " + damage + " damage to " + ennemy.getName());
            else
                logger.log(ennemy.getName() + " have dodge the attack !");
            if (ennemy.getHealthpoint() > 0)
            {
                damage = ennemy.attack(player);
                if (damage > 0)
                    logger.log(ennemy.getName() + " hit you for " + damage + " damage.");
                else
                    logger.log("You have dodged the ennemy  attack !");
            }
        }
        if (ennemy.getHealthpoint() < 0) {
            gameUI.getMoveButton().setEnabled(true);
            gameUI.getFightButton().setEnabled(false);
            gameUI.getRunButton().setEnabled(false);
            for (int i = 0; i < monsters.size(); i++) {
                if (monsters.get(i).getPosition_x() == player.getPosition_x() &&
                        monsters.get(i).getPosition_y() == player.getPosition_y()) {
                    player.setExperience(player.getExperience() + monsters.get(i).getLevel() * 100);
                    monsters.remove(i);
                }
            }
        }
        map.notification();
    }

    private void playerRun()
    {
        int canRun = Dice.roll(1, 3);
        logger.log("[DEBUG] CanRun: " + canRun);
        if (canRun == 1)
        {
            player.setPosition_x(player.getPreviousPositionX());
            player.setPosition_y(player.getPreviousPositionY());
            gameUI.getMoveButton().setEnabled(true);
            gameUI.getFightButton().setEnabled(false);
            gameUI.getRunButton().setEnabled(false);
            map.notification();
            logger.log("You have flee from the battle !");
            return ;
        }
        logger.log("You are cornered and you can not flee !");
        gameUI.getRunButton().setEnabled(false);
    }

    private boolean isOutsideBorderOfMap(Character character)
    {
        int playerX = player.getPosition_x();
        int playerY = player.getPosition_y();
        int mapRadius = map.getCells().length - 1;

        if (playerX < 0 || playerY < 0 || playerX > mapRadius|| playerY > mapRadius)
            return (true);
        return (false);
    }
}