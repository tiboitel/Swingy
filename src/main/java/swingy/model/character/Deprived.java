package swingy.model.character;

import swingy.helper.Dice;
import swingy.helper.NameGenerator;

public class Deprived extends Character {
    public Deprived() {
        super();
        this.name = NameGenerator.generate();
        this.setLevel(1);
        this.setHealthpoint(10 + Dice.roll(1, 4));
        this.setCombatCapacity(20 + Dice.roll(4, 6));
        this.setStrength(20 + Dice.roll(4, 6));
        this.setAgility(20 + Dice.roll(4, 6));
        this.setIntelligence(20 + Dice.roll(4, 6));
        this.setAttack(2);
        this.setGlyph('$');
    }

    public String getPlayerclass()
    {
        return "Deprived";
    }

    public void attack(Character character)
    {

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
