package swingy.model.character;

import swingy.model.artifact.Artifact;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
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
    protected char glyph;
    public abstract void attack(Character target);
}