package swingy.model.character;

import swingy.model.AbstractModel;
import swingy.model.artifact.Artifact;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public abstract class Character extends AbstractModel {
    protected String name;
    protected int level;
    protected int experience;
    protected int attack;
    protected int defense;
    protected int healthpoint;
    protected int combatCapacity;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int position_x;
    protected int position_y;
    protected char glyph;
    protected ArrayList<Artifact> equipment;

    public abstract void attack(Character target);
    public abstract String getPlayerclass();

    public void notification()
    {
        this.gameUI.update(this);
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