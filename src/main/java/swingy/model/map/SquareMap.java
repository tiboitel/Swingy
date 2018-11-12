package swingy.model.map;

import java.util.Arrays;

public class SquareMap {
    public char[][] cells;

    public SquareMap(int mapSize)
    {
        cells = new char[mapSize][mapSize];
        for (char[] row : cells)
            Arrays.fill(row, '.');
    }

    public String toString()
    {
        String output = "";

        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++)
            {
                output += cells[i][j];
            }
            output += "\n";
        }
        return output;
    }
}
