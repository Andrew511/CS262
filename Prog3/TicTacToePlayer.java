
/**
 * Abstract class of TicTacToePlayer, provides the baseline for all tic tac toe strategies.
 * 
 * @author Andrew Wrege
 * @version 11/6/16
 */
public abstract class TicTacToePlayer
{
    String name;
    int score;
    char symbol;
    /* basic constructor for tic tac toe strategies.
     * 
     * @param name the name of the player object, and how it is identified.
     * @param symbol whether the player is X's or O's
     */
    public TicTacToePlayer(String name, char symbol)
    {
        this.name = name;
        this.score = 0;
        this.symbol = symbol;
    }

    /*makes a move for the tic tac toe strategy.
     * 
     * @return int[] the location where the move will be made on the board.
     */
    public abstract int[] makeMove();

    /*
     * resets all instance variables within the strategies and setting it to it's default state.
     */
    public abstract void reset();
}
