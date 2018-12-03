package swingy.model.character;

import swingy.enums.EArtifact;
import swingy.helper.ArtifactFactory;
import swingy.helper.Dice;
import swingy.helper.NameGenerator;
import swingy.model.artifact.Artifact;

public class Monster extends Character {
    public Monster() {
        super();
        this.name = NameGenerator.generate();
        this.setLevel(1);
        this.setHealthpoint(Dice.roll(1, 8));
        this.setCombatCapacity(Dice.roll(4, 6));
        this.setStrength(10 + Dice.roll(3, 10));
        this.setAgility(10 + Dice.roll(2, 10));
        this.setIntelligence(10 + Dice.roll(2, 10));
        this.setAttack(1);
        this.setGlyph('G');
    }

    public String getPlayerclass()
    {
        return "Monster";
    }

    public void attack(Character character)
    {

    }

    public Artifact drop()
    {
        int drop_chance = 30;

        if ((Dice.roll(1,10) * 10) < drop_chance)
            return ArtifactFactory.newArtifact(EArtifact.HELM, "Rusty Helmet", 1);
        return null;
    }

    public String toString()
    {
        String output = "Name: " + this.getName() +
                "\nCombat Capacity:" + this.getCombatCapacity() +
                "\nStrength: " + this.getStrength() +
                "\nAgility: " + this.getAgility() +
                "\nIntelligence:" + this.getIntelligence();
        return (output);
    }
}
