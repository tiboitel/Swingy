package swingy.model.character;

import swingy.helper.Dice;

public class Warrior extends Character {
    public Warrior() {
        super();
        this.name = "Arathorn";
        this.setHealthpoint(10 + Dice.roll(1, 4));
        this.setCombatCapacity(20 + Dice.roll(2, 10));
        this.setStrength(20 + Dice.roll(2, 10));
        this.setAgility(20 + Dice.roll(2, 10));
        this.setIntelligence(20 + Dice.roll(2, 10));
        this.setAttack(2);
        this.setGlyph('$');
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
