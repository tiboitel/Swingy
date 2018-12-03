package swingy.model.map;

import lombok.Getter;
import lombok.Setter;
import swingy.model.AbstractModel;
import swingy.model.IObservable;
import swingy.model.character.Character;
import swingy.model.character.Monster;

import java.util.Arrays;
import java.util.LinkedList;

public class SquareMap extends AbstractModel
{
    private char[][] cells;
    private Character player;
    private LinkedList<Monster> monsters;

    public SquareMap(int mapSize)
    {
        cells = new char[mapSize][mapSize];
        for (char[] row : cells)
            Arrays.fill(row, '.');
    }

    public String toString()
    {
        String output = "";

        cells[player.getPosition_x()][player.getPosition_y()] = player.getGlyph();
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++) {
                output += cells[i][j] + "  ";
            }
            output += "\n";
        }
        return output;
    }

    public void setPlayer(Character player)
    {
        this.player = player;
    }
    public void setMonsters(LinkedList<Monster> monsters) { this.monsters = monsters; }

    public void notification()
    {
        gameUI.update(this);
    }
}
