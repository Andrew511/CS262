
/**
 * Defensive strategy for Tic Tac Toe, looks for any row with more than 2 pieces and blocks it,
 * otherwise attempting to control the corners of the board.
 * 
 * @author Andrew Wrege
 * @version 11/6/16
 */
public class TicTacToePlayerSmart extends TicTacToePlayer
{
    private final int ABOUT_TO_WIN = 2;
    /* basic constructor for tic tac toe strategies.
     * 
     * @param name the name of the player object, and how it is identified.
     * @param symbol whether the player is X's or O's
     */
    public TicTacToePlayerSmart(String name, char symbol)
    {
        super(name, symbol);
    }

    /*makes a move for the tic tac toe strategy, by checking what rows/columns are almost full of pieces and blocks
     * them otherwise following a predetermined path controlling the corners if it is not threatened.
     * 
     * @return int[] the location where the move will be made on the board.
     */
    public int[] makeMove()
    {
        int[] move;
        move = checkRows();
        if (move[0] != -1)
            return move;
        move = checkColumns();
        if (move[0] != -1)
            return move;
        move = checkDiagonals();
        if (move[0] != -1)
            return move;
        return normalPlay();
    }

    /*
     * resets all instance variables within the strategies and setting it to it's default state.
     */
    public void reset()
    {
        this.score = 0;
    }

    /*checks the rows to see if they are almost full and a move needs to be made to prevent opponent from winning
     * 
     * @return int[] the location where the move will be made on the board or if a move does not need to be made.
     */
    private int[] checkRows()
    {
        for (int i = 0; i < TicTacToeSimulator.BOARD_SIZE; i++)
        {
            int almostFull = 0;
            for (int j = 0; j < TicTacToeSimulator.BOARD_SIZE; j++)
            {
                if (TicTacToeSimulator.board[i][j] != TicTacToeSimulator.EMPTY && TicTacToeSimulator.board[i][j] != this.symbol)
                    almostFull++;
            }
            if (almostFull == ABOUT_TO_WIN)
                for (int j = 0; j < TicTacToeSimulator.BOARD_SIZE; j++)
                    if (TicTacToeSimulator.board[i][j] == TicTacToeSimulator.EMPTY)
                        return new int[] {i, j};
        }
        return new int[] {-1, -1};
    }

    /*checks the columns to see if they are almost full and a move needs to be made to prevent opponent from winning
     * 
     * @return int[] the location where the move will be made on the board or if a move does not need to be made.
     */
    private int[] checkColumns()
    {
        for (int i = 0; i < TicTacToeSimulator.BOARD_SIZE; i++)
        {
            int almostFull = 0;
            for (int j = 0; j < TicTacToeSimulator.BOARD_SIZE; j++)
            {
                if (TicTacToeSimulator.board[j][i] != TicTacToeSimulator.EMPTY && TicTacToeSimulator.board[j][i] != this.symbol)
                    almostFull++;
            }
            if (almostFull == ABOUT_TO_WIN)
                for (int j = 0; j < TicTacToeSimulator.BOARD_SIZE; j++)
                    if (TicTacToeSimulator.board[j][i] == TicTacToeSimulator.EMPTY)
                        return new int[] {j, i};
        }
        return new int[] {-1, -1};
    }

    /*checks both ddiagonals to see if they are almost full and a move needs to be made to prevent opponent from winning
     * 
     * @return int[] the location where the move will be made on the board or if a move does not need to be made.
     */
    private int[] checkDiagonals()
    {
        int almostFull = 0;
        for (int i = 0; i < TicTacToeSimulator.BOARD_SIZE; i++)

            if (TicTacToeSimulator.board[i][i] != TicTacToeSimulator.EMPTY && TicTacToeSimulator.board[i][i] != this.symbol)
                almostFull++;
        if (almostFull == ABOUT_TO_WIN)
            for (int i = 0; i < TicTacToeSimulator.BOARD_SIZE; i++)
                if (TicTacToeSimulator.board[i][i] == TicTacToeSimulator.EMPTY)
                    return new int[] {i, i};
        for (int i = TicTacToeSimulator.BOARD_SIZE - 1; i >= 0; i--)

            if (TicTacToeSimulator.board[i][i] != TicTacToeSimulator.EMPTY && TicTacToeSimulator.board[i][i] != this.symbol)
                almostFull++;
        if (almostFull == ABOUT_TO_WIN)
            for (int i = TicTacToeSimulator.BOARD_SIZE - 1; i >= 0; i--)
                if (TicTacToeSimulator.board[i][i] == TicTacToeSimulator.EMPTY)
                    return new int[] {i, i};
        return new int[] {-1, -1};
    }

    /* normal strategy to be followed if there is no threat of losing to the opponent, focusing on securing corners to prevent
     * multiple win states.
     * 
     * @return int[] the location where the move will be made on the board or if a move does not need to be made.
     */
    private int[] normalPlay()
    {
        int middle = TicTacToeSimulator.BOARD_SIZE / 2;
        if (TicTacToeSimulator.board[middle][middle] == TicTacToeSimulator.EMPTY)
            return new int[] {middle, middle};
        if (TicTacToeSimulator.board[0][0] == TicTacToeSimulator.EMPTY)
            return new int[] {0, 0};
        if (TicTacToeSimulator.board[TicTacToeSimulator.BOARD_SIZE - 1][TicTacToeSimulator.BOARD_SIZE - 1] == TicTacToeSimulator.EMPTY)
            return new int[] {TicTacToeSimulator.BOARD_SIZE - 1, TicTacToeSimulator.BOARD_SIZE - 1};
        if (TicTacToeSimulator.board[0][TicTacToeSimulator.BOARD_SIZE - 1] == TicTacToeSimulator.EMPTY)
            return new int[] {0, TicTacToeSimulator.BOARD_SIZE - 1};
        if (TicTacToeSimulator.board[TicTacToeSimulator.BOARD_SIZE - 1][0] == TicTacToeSimulator.EMPTY)
            return new int[] {TicTacToeSimulator.BOARD_SIZE - 1, 0};
        for (int i = 0; i < TicTacToeSimulator.BOARD_SIZE; i++)
        {
            for (int j = 0; j < TicTacToeSimulator.BOARD_SIZE; j++)
            {
                if (TicTacToeSimulator.board[j][i] == TicTacToeSimulator.EMPTY)
                    return new int[] {j, i};
            }
        }
        return new int[] {-1, -1};
    }
}
