import java.util.Random;

/**
 * Strategy for Tic Tac Toe, Picks random spots on the board to place its piece
 * 
 * @author Andrew Wrege
 * @version 11/6/16
 */
public class TicTacToePlayerDumb extends TicTacToePlayer
{
    Random gen = new Random();
    /* basic constructor for tic tac toe strategies.
     * 
     * @param name the name of the player object, and how it is identified.
     * @param symbol whether the player is X's or O's
     */
    public TicTacToePlayerDumb(String name,char symbol)
    {
        super(name, symbol);
    }

    /*makes a move for the tic tac toe strategy using a random number generator that generates
     * a position on the board.
     * 
     * @return int[] the location where the move will be made on the board.
     */
    public int[] makeMove()
    {
        return new int[] {gen.nextInt(3), gen.nextInt(3)};
    }

    /*
     * resets all instance variables within the strategies and setting it to it's default state.
     */
    public void reset()
    {
        this.score = 0;
    }
}