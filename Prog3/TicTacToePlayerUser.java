import java.util.Scanner;
/**
 * Tic Tac Toe strategy that relies on user input to make decisions of where to make moves.
 * 
 * @author Andrew Wrege
 * @version 11/6/16
 */
public class TicTacToePlayerUser extends TicTacToePlayer
{
    Scanner in = new Scanner(System.in);
    /* basic constructor for tic tac toe strategies.
     * 
     * @param name the name of the player object, and how it is identified.
     * @param symbol whether the player is X's or O's
     */
    public TicTacToePlayerUser(String name, char symbol)
    {
        super(name, symbol);
    }

    /*makes a move for the tic tac toe strategy using user input to select where to place the piece.
     * 
     * @return int[] the location where the move will be made on the board.
     */
    public int[] makeMove()
    {
        int x = -1, y = -1;
        while (x > 2 || x < 0 || y > 2 || y < 0)
        {
            System.out.println("Please enter the coordinates of your piece placement, valid selections are 0-2");
            x = in.nextInt();
            y = in.nextInt();
        }
        return new int[] {x, y};
    }

    /*
     * resets all instance variables within the strategies and setting it to it's default state.
     */
    public void reset()
    {
        this.score = 0;
    }
}
