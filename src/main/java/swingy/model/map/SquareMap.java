package swingy.model.map;

import lombok.Getter;
import lombok.Setter;
import swingy.model.AbstractModel;
import swingy.model.character.Character;
import swingy.model.character.Monster;

import java.util.Arrays;
import java.util.LinkedList;

@Getter
@Setter
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

        // Fills the array with empty dot. Aka, cells.
        for (int i = 0; i < cells.length; i++)
            Arrays.fill(cells[i], '.');
        // Set player and monster glyph on the map.
        cells[player.getPosition_y()][player.getPosition_x()] = player.getGlyph();
        System.out.println((monsters.size()));
        for (Monster monster : monsters) {
            cells[monster.getPosition_y()][monster.getPosition_x()] = monster.getGlyph();
        }
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++) {
                output += cells[i][j] + "  ";
            }
            output += "\n";
        }
        return output;
    }

    public void notification()
    {
        gameUI.update(this);
    }
}
