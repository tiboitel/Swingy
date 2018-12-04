package swingy.helper;

import swingy.enums.EArtifact;
import swingy.enums.ECharacterClass;
import swingy.model.artifact.Artifact;
import swingy.model.character.*;
import swingy.model.character.Character;

import java.util.ArrayList;

public class CharacterFactory {

    public static Character newCharacter(ECharacterClass type)
    {
        Character player;
        ArrayList<Artifact> inventory = new ArrayList<Artifact>();

        switch (type)
        {
            case WARRIOR:
                player = new Warrior();
                inventory.add(ArtifactFactory.newArtifact(EArtifact.HELM, "Leather Helmet", 1));
                inventory.add(ArtifactFactory.newArtifact(EArtifact.ARMOR, "Chain mail", 3));
                inventory.add(ArtifactFactory.newArtifact(EArtifact.WEAPON, "Rusted Sword", 2));
                break;
            case WIZARD:
                player = new Wizard();
                  inventory.add(ArtifactFactory.newArtifact(EArtifact.HELM, "Weird Hat", 2));
                  inventory.add(ArtifactFactory.newArtifact(EArtifact.ARMOR, "Linen Dress", 0));
                  inventory.add(ArtifactFactory.newArtifact(EArtifact.WEAPON, "Old Oak Staff", 3));
                break;
            case ROGUE:
                inventory.add(ArtifactFactory.newArtifact(EArtifact.HELM, "Dark Hood", 1));
                inventory.add(ArtifactFactory.newArtifact(EArtifact.ARMOR, "Leather Armour", 1));
                inventory.add(ArtifactFactory.newArtifact(EArtifact.WEAPON, "Mercenary Sword", 3));
                player = new Rogue();
                break;
            default:
                inventory.add(ArtifactFactory.newArtifact(EArtifact.HELM, "Dark Hood", 1));
                inventory.add(ArtifactFactory.newArtifact(EArtifact.ARMOR, "Leather Armour", 1));
                inventory.add(ArtifactFactory.newArtifact(EArtifact.WEAPON, "Mercenary Sword", 1));
                player = new Deprived();
                break;
        }
        player.setName(NameGenerator.generate());
        player.setEquipment(inventory);
        player.setGlyph('$');
        return (player);
    }
}
