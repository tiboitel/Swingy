package swingy.controller;

import swingy.enums.ECharacterClass;
import swingy.helper.CharacterFactory;
import swingy.model.character.Character;

public class CharacterCreationController {

    private static CharacterCreationController instance = null;
    // private CharacterCreationView view;
    private Character player;

    public static CharacterCreationController getInstance()
    {
        if (instance == null)
            instance = new CharacterCreationController();
        return instance;
    }

    public void CreateNewCharacter(int characterClass) {
        player = CharacterFactory.newCharacter(ECharacterClass.values()[characterClass]);
        player.toString();
    }

    public void LoadLastPlayedCharacter()
    {

    }

}
