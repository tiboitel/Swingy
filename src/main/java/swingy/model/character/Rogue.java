package swingy.model.character;

import swingy.helper.Dice;
import swingy.helper.NameGenerator;

public class Rogue extends Character {
    public Rogue() {
        super();
        this.name = NameGenerator.generate();
        this.setLevel(1);
        this.setHealthpoint(10 + Dice.roll(1, 4));
        this.setCombatCapacity(20 + Dice.roll(2, 10));
        this.setStrength(20 + Dice.roll(2, 10));
        this.setAgility(20 + Dice.roll(2, 10));
        this.setIntelligence(20 + Dice.roll(2, 10));
        this.setAttack(2);
    }

    public String getPlayerclass()
    {
        return "Rogue";
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
