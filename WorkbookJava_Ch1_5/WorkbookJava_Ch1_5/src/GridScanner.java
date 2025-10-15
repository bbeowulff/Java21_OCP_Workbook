public class GridScanner
{

    public static void main(String[] args)
    {
        char[][] grid = {
                {'.', '.', '#', '.'},
                {'a', '#', 'b', '2'},
                {'.', '.', '.', '.'}
        };
        scanGrid(grid);
    }

    public static void scanGrid(char[][] grid)
    {
        boolean found = false;
        outerLoop:
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[row].length; col++)
            {
                char cell = grid[row][col];

                if (cell == '#')
                {
                    continue;
                }

                if (Character.isDigit(cell))
                {
                    System.out.printf("found digit '%c' at (row=%d, col=%d)%n", cell, row, col);
                    found = true;
                    break outerLoop;
                }
            }
        }

        if (!found) {
            System.out.println("none");
        }
    }
}
