import java.util.Scanner;
/**
 * Runs and manages the instance of a TicTacToe game, keeping information not needed private from the players and refusing them access to methods that run the
 *  game preventing them from exploiting it.
 * 
 * @author Andrew Wrege
 * @version 11/6/16
 */
public class TicTacToeSimulator
{
    public static final int BOARD_SIZE = 3, TURN_LIMIT = 9  ;
    private static final char X = 'X', O = 'O';
    private static int[] move;
    public static final char  EMPTY = ' ';
    public static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static int turn = 0;
    private static boolean gameOver = false;
    /*
     * Initializes the board into being filled with empty spaces and clears any of the previous games pieces.
     */
    private static void initialize()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                board[j][i] = EMPTY;
    }

    /*
     * prints the board into the terminal and shows any updates
     */
    private static void printBoard()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            if (i > 0)
                System.out.println("-+-+-");
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                if (j > 0)
                    System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    /*
     * checks if a position within the board is a valid move or not
     * 
     * @param y the y coordinate on the board of the move
     * @param x the x coordinate on the board of the move
     * @return returns a boolean for the validity of the board position, true = valid move, otherwise false.
     */
    public static boolean isValid(int x, int y)
    {
        if (board[x][y] != EMPTY)
            return false;
        return true;
    }

    /*
     * checks if a player has won and achieved 3 pieces in a row.
     * 
     * @param moveLocation the board coordinate where the move was placed
     * @param winSymbol the symbol that the player is using, is used to see if three of these are lined up.
     * 
     * @return boolean true for win false for hasnt won yet
     */
    private static boolean checkWin(int[] moveLocation, char winSymbol)
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            if (board[moveLocation[0]][i] != winSymbol)
                break;
            if (i == BOARD_SIZE - 1)
                return true;
        }
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            if (board[i][moveLocation[1]] != winSymbol)
                break;
            if (i == BOARD_SIZE - 1)
                return true;
        }
        if (moveLocation[0] == moveLocation[1])
            for (int i = 0; i < TicTacToeSimulator.BOARD_SIZE; i++)
            {
                if (board[i][i] != winSymbol)
                    break;
                if (i == BOARD_SIZE - 1)
                    return true;
            }
        if (moveLocation[0] == 0 && moveLocation[1] == board.length - 1 || moveLocation[0] == board.length - 1 && moveLocation[1] == 0)
            for (int i = TicTacToeSimulator.BOARD_SIZE - 1; i >= 0; i--)
            {
                if (board[i][i] != winSymbol)
                    break;
                if (i == 0)
                    return true;
            }
        return false;
    }

    /*
     * has the inputted player take his turn and runs any necessary script for him to do that.
     * 
     * @param player the player taking the turn
     * @param opposingPlayer the player not currently taking a turn, used in case current player makes a invalid move and loses.
     */
    private static void takeTurn(TicTacToePlayer player, TicTacToePlayer opposingPlayer)
    {
        move = player.makeMove();
        if (isValid(move[0],move[1]) != true)
        {
            opposingPlayer.score += 1;
            System.out.println(opposingPlayer.name + " has won due to a invalid move! Their score is: " + opposingPlayer.score);
            return;
        }
        board[move[0]][move[1]] = player.symbol;
        printBoard();
        System.out.println(player.name + " (" + player.symbol + ")" + " marked position " + "(" + move[0] + ", " + move[1] + ")");
        if (checkWin(move, player.symbol) == true)
        {
            player.score += 1;
            System.out.println(player.name + " has won! Their score is: " + player.score);
            gameOver = true;
            return;
        }
        turn++;
    }

    /*
     * runs the main game loop and calls all necessary functions, also initializes both players and the board.
     */
    public static void main(String args[])
    {
        int[] move;
        String keepPlaying = "";
        Scanner scan = new Scanner(System.in);
        TicTacToePlayer player1 = new TicTacToePlayerSmart("Smart", X);
        TicTacToePlayer player2 = new TicTacToePlayerSmart("Smart2", O);
        while (!keepPlaying.equals("quit"))
        {
            initialize();
            gameOver = false;
            takeTurn(player1, player2); // first turn for player 1
            while (gameOver != true)
            {
                takeTurn(player2, player1);
                if (gameOver == true)
                    break; // if player2 wins during their turn, skip player1's
                takeTurn(player1, player2);
                if (turn == TURN_LIMIT)
                {
                    System.out.println("Draw");
                    gameOver = true;
                }
            }
            System.out.println("Game Over! Input quit to quit, any other input to keep playing.");
            keepPlaying = scan.next();
        }
    }

}
