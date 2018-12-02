import java.util.Scanner;

/**
 * Creates and handles Textris game objects, handling placement of pieces as well as removing lines, and updating the score,
 * as well as updating the selected piece and initilizing the game board.
 * 
 * @Andrew Wrege 
 * @1.0
 */
public class Textris
{

   private static final int COLS = 6;
   private static final int ROWS = 7;
   private static int ZEE = 0;
   private static int TEE = 1;
   private static int ES = 2;
   private static int EYE = 3;
   private static int OH = 4;
   private static int JAY = 5;
   private static int EL = 6;
   
   /**
    * Returns a 2d int array that represents the for of a textris piece, for use by other methods in placing within the board.
    * 
    * @return a random textris piece, represented as a 2d array, #'s are the parts of the "piece"
    */
   private char[][] getRandomPiece()
   {
      int rint = new java.util.Random().nextInt(7);
      if (rint == ZEE)
         return new char[][]{{'#', '#', ' '}, {' ', '#', '#'}};
      else if (rint == TEE)
         return new char[][]{{' ', '#', ' '}, {'#', '#', '#'}};
      else if (rint == ES)
         return new char[][]{{' ', '#', '#'}, {'#', '#', ' '}};
      else if (rint == EYE)
         return new char[][]{{' ', ' ', ' ', ' '}, {'#', '#', '#', '#'}};
      else if (rint == OH)
         return new char[][]{{'#', '#'}, {'#', '#'}};
      else if (rint == JAY)
         return new char[][]{{'#', ' ', ' '}, {'#', '#', '#'}};
      else //if (rint == EL)
         return new char[][]{{' ', ' ', '#'}, {'#', '#', '#'}};
   }
   
   /**
    * Prints out the currently selected textris piece to be used this turn.
    * 
    */
   public void printCurrentPiece()
   {
      if (currentPiece == null)
         return;
      System.out.println("Current piece:");
      System.out.println();
      for (int i = 0; i < currentPiece.length; i++)
      {
         System.out.print("|");
         for (int j = 0; j < currentPiece[0].length; j++)
         {
            System.out.print(currentPiece[i][j]);
            /*if (currentPiece[i][j] == ' ')
               System.out.print(" ");
            else
               System.out.print("#");*/
            System.out.print("|");
         }
         System.out.println();
      }
      System.out.println();
   }
   
   private char[][] board;
   private char[][] currentPiece;
   private int lines = 0;

   
   /**
    * Returns the width of the current textris piece.
    * 
    * @return width of the current piece
    */
   public int getCurrentPieceWidth()
   {
      int width = 0;
      for (int i = 0;i < currentPiece[0].length; i++)
      {
          for (int j = 0;j < currentPiece.length; j++)
          {
              if (currentPiece[j][i] == '#')
              {
                  width++;
                  j = currentPiece.length;
              }
          }
      }
      return width;
   }
   
   /**
    * returns the number of lines cleared throughout the current game
    * 
    * @return the number of cleared lines (score)
    */
   public int getNumLines()
   {
      return lines;
   }
   
   /**
    * Initilizes the game board with the number of rows and columns in the parameters as well as selecting a
    * random textris piece
    * 
    *  @param numRows the number of rows within the game board
    *  @param numCols the number of columns within the game board
    *  
    */
   public void initializeBoard(int numRows, int numCols)
   {
      board = new char[numRows][numCols];
      for (int i = 0;i < board.length; i++)
      {
          for (int j = 0;j < board[0].length; j++)
          {
              board[i][j] = ' ';
          }
      }
      currentPiece = getRandomPiece();
   }
   
   /**
    * prints the current board as well as positions of all textris pieces currently on it.
    */
   public void printBoard()
   {
     for (int i = 0;i < board.length; i++)
     {
        for (int j = 0;j < board[0].length; j++)
        {
           System.out.print("|");
           System.out.print(board[i][j]);
        }
        System.out.println("|");
     } 
     System.out.println();
     System.out.print(" ");
     for (int i = 0; i < board.length - 1; i++)
        System.out.print (i + " ");
   }
   
   
   
   /**
    * Places a textris piece within it's columnSelection, respecting existing textris pieces and ending the game
    * if the current piece would be placed off the game board.
    * 
    * @param columnSelection the column the left most part of the current textris piece starts on and proceeds right from there.
    * 
    * @return true if the textris piece is off the board, ending the game, false if the placement is valid and the game 
    * continues.
    */
   public boolean placeCurrentPiece(int columnSelection)
   {
       for (int i = 0;i < board.length; i++)
       {    // Scans through the column of the current piece to find the first obstacle or if the piece should be placed on the bottom of the board.
           for (int j = columnSelection; j < (columnSelection + getCurrentPieceWidth()); j++)
           {
               if (board[i][j] == '#' && i == 0)
                return true;
               if (board[i][j] == '#' ||  (i == board.length - 1 && j == (columnSelection + getCurrentPieceWidth() - 1)))
               {
                   if ( board[i][j] == '#' && currentPiece[1][j - columnSelection] == '#')
                        i--; 
                   for (int x = 1; x > -1; x--)
                   {  
                       for (int y = 0; y < currentPiece[0].length; y++)
                       {  //prints the current textris piece into the board at the point found by the nested for loop above, taking into account surrounding textris pieces.
                          if (currentPiece[x][y] == '#' && i < 0)
                             return true;
                          if (currentPiece[x][y] == '#')
                             board[i][columnSelection + y] = currentPiece[x][y];
                       }
                        i--;
                   }
                   return false;
               }
           }
       }
        return false;
    }
   
   /**
    * checks for complete rows within the board, deletes them and then adds 1 to lines (score)
    */
   public void checkForLines()
   {
      for (int i = 0;i < board.length; i++)
      {
          for (int j = 0;j < board[0].length; j++)
          {
              if (board[i][j] != '#')
              {
                  break; //breaks from the current line if it does not continue with constant #s
              }
              if (j == board[i].length - 1)
              {
                  lines++;
                  for (int delete = 0; delete < board[0].length; delete++)
                  { 
                      board[i][delete] = ' '; //deletes a completed row
                  }
                  for (int r = i; r > 0; r--)
                  {
                      for(int e = 0; e < board[r].length; e++)
                      {
                          board[r][e] = board[r - 1][e]; //moves every row above the completed row down 1 row
                      }
                  }
              }
          }
      }
      currentPiece = getRandomPiece();
   }
   
   
   /**
    * prompts the player for a column to place the current textris piece in, takes into account the pieces width
    * and disallowing any columns the piece would not fit within and then returns the players selection for use in other
    * methods.
    * 
    * @param currentPieceWidth the width of the current piece, used to determine valid columns for the piece to go in.
    * 
    * @return selection the selected column by the player for the textris piece to go into.
    */
   private static int getColumn(int currentPieceWidth)
   {
      boolean validSelection = false;
      int selection = -1;
      Scanner in = new Scanner(System.in);
      while (!validSelection)
      {
          System.out.println("Please enter your column selection. Valid columns are " + "0 - " + (COLS - currentPieceWidth));
          selection = in.nextInt();
          if (selection < 0 || selection > (COLS - currentPieceWidth))
          {
              System.out.println("Bad column selection");
          }
          else 
          {
              validSelection = true;
          }
      }
      return selection;
   }
   
   
   /**
    * Do not modify any of the code in the main method.
    */
   public static void main(String args[])
   {
      boolean gameOver = false;
      Textris game = new Textris();
      game.initializeBoard(ROWS, COLS);
      while (!gameOver)
      {
         System.out.println("Current score: " + game.getNumLines());
         game.printCurrentPiece();
         game.printBoard();
         int column = getColumn(game.getCurrentPieceWidth());
         gameOver = game.placeCurrentPiece(column);
         if (!gameOver)
            game.checkForLines();
         System.out.println("\n");
      }
      System.out.println("Game OVER!");
   }
}