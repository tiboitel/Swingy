package swingy.model.character;

import swingy.helper.Dice;
import swingy.model.AbstractModel;
import swingy.model.IObservable;
import swingy.model.artifact.Artifact;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public abstract class Character extends AbstractModel implements IObservable {
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
    protected int previousPositionX;
    protected int previousPositionY;
    protected char glyph;
    protected ArrayList<Artifact> equipment;

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

    public int attack(Character target)
    {
        int hit, damage = 0;
        for (int i = 0; i < this.getAttack(); i++) {
            hit = Dice.roll(1, 100);
            if (hit < this.getCombatCapacity()) {
                damage += Dice.roll(1, this.getEquipment().get(2).getBonus() + 1);
                damage += Math.round(this.getStrength() / 10);
            }
        }
        target.setHealthpoint(target.getHealthpoint() - damage);
        return (damage);
    }

    public void save()
    {

    }
}