import java.util.Random;
/**
 * Write a description of class SelfAvoidingRandomWalk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelfAvoidingRandomWalk
{
    private int currCol, currRow, walkLength;
    private char[][] board;
    private char start = '$';
    private char north = 'N';
    private char south = 'S';
    private char east = 'E';
    private char west = 'W';

    // Fill in the missing details. You might consider having other
    // private helper methods. 
    
    // Initialize self-avoiding random walk. Hint: you will need
    // to have private data to keep track of the grid, the current
    // row and current column.
    public SelfAvoidingRandomWalk(int numRows, 
                                  int numColumns,
                                  int startRow, 
                                  int startColumn)
    {
        board = new char[numRows][numColumns];
        board[startRow][startColumn] = start;
        currRow = startRow;
        currCol = startColumn;
    }
    
    // Move the random walk one step ahead in some randomly chosen
    // direction.
    public void step()
    {
        int direction = new Random().nextInt(4);
        if (direction == 0)
        {
            if (currRow != 0 && board[currRow - 1][currCol] == 0)
            {
                this.currRow = currRow - 1;
                board[currRow][currCol] = north;
                walkLength++;
            }
        }
        else if (direction == 1)
        {
            if ((currRow + 1) % board.length != 0 && board[currRow + 1][currCol] == 0)
            {
                this.currRow = currRow + 1;
                board[currRow][currCol] = south;
                walkLength++;
            }
        }
        else if (direction == 2)
        {
            if ((currCol + 1) % board[0].length != 0 && board[currRow][currCol + 1] == 0)
            {
                this.currCol = currCol + 1;
                board[currRow][currCol] = east;
                walkLength++;
            }
        }
        else if (direction == 3)
        {
            if (currCol != 0 && board[currRow][currCol - 1] == 0)
            {
                this.currCol = currCol - 1;
                board[currRow][currCol] = west;
                walkLength++;
            }
        }
    }
    
    // Return true if the walk can take another step in some
    // direction and false otherwise.
    public boolean canTakeStep()
    {
        if ((currRow != 0 && board[currRow - 1][currCol] == 0)
            || ((currRow + 1) % board.length != 0 && board[currRow + 1][currCol] == 0)
            || ((currCol + 1) % board[0].length != 0 && board[currRow][currCol + 1] == 0)
            || (currCol != 0 && board[currRow][currCol - 1] == 0))
            return true;
        else return false;
    }
    
    // Return the length of the walk. Hint: you will have to have
    // a variable to keep track of the length of the walk.
    public int length() 
    {
        return walkLength;
    }
    
    // Print out the grid according to the sample output format.
    public void print()
    {
        System.out.print("+");
        for (int i = 0; i < board[0].length; i++)
            System.out.print("-");
        System.out.print("+");
        System.out.println();
        for (int i = 0; i < board.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 0)
                {
                    System.out.print(" ");
                }
                else {
                    System.out.print(board[i][j]);
                }
            System.out.println("|");
        }
        System.out.print("+");
        for (int i = 0; i < board[0].length; i++)
            System.out.print("-");
        System.out.print("+");
        System.out.println();
    }

}
