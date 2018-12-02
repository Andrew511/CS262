import java.util.Random;
/**
 * The purpose of this program is to create a random array that is sorted within its rows and columns, 
 * and then implement a search algorithm to find a specific value
 * 
 * @author Andrew Wrege 
 * @version 10/24/2016
 */
public class Prog2
{
    /*
     * Returns a 2d array of size inSize squared for use in the search algorithm, this array is random and sorted.
     * 
     * @param inSize the size of the the array, will be squared to get the actual size.
     * @return returns the completed random sorted array.
     */
    public static int[][] getRandomSorted2DArray(int inSize)
    {
        int[][] data = new int[recPow(2,inSize) - 1][recPow(2,inSize) - 1];
        Random random = new Random();
        for (int i = data.length - 1; i >= 0; i--)
        {
            for (int j = data[i].length - 1; j >= 0; j--)
            {
                if(j == data[i].length - 1 && i == data.length - 1)
                {
                    data[i][j] = random.nextInt(20);
                }
                else if  (j == data[i].length - 1)
                {
                    data[i][j] = data[i + 1][j] + random.nextInt(20);
                }
                else if (i == data.length - 1)
                {
                    data[i][j] = data[i][j + 1] + random.nextInt(20);
                }
                else
                    while (data[i][j] < data[i + 1][j] || data[i][j] < data[i][j + 1])
                        data[i][j] = data[i][j + 1] + random.nextInt(20);
            }
        }
        return data;
    }
    /*
     * recursively brings the base to the power inputted.
     * 
     * @int base the base number to be brought to a power
     * @int power the power that the base will be brought to.
     * 
     * @return returns the base after it has been raised to the power.
     */
    public static int recPow(int base, int power)
    {
        if ( power == 0)
            return 1;
        return base * recPow(base, --power);
    }

    /*
     * prints out an inputted 2d array
     * 
     * @param data the 2d array that should be printed out
     */
    public static void print2D(int[][] data)
    {
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[i].length; j++)
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
     * searches through a 2d array recursively, first checking the middle row and column for the value
     * then moving onto 3 of the 4 corner quadrants depending on whether the value is larger than the middle value
     * or not.
     * 
     * @param data the 2D array to be searched
     * @param left the left bound of the search
     * @param right the right bound of the search
     * @param top the upper bound of the search
     * @param bottom the lower bound of the search
     * @param val the value to be searched for by the algorithm
     * 
     * @return returns -1, -1 if the val is not found, or the coordinates of the value in the array
     */
    public static int[] threeQuarterSearch(int[][] data, int left, int right, int top, int bottom, int val)
    {
        if (right - left == 1 || bottom - top == 1)
        {
            return new int[] {-1, -1};
        }
        if ((left + right)/ 2 != 0 && binarySearchRow(data[(top + bottom) / 2], val, left, right, (top + bottom) / 2)[0] != -1)
            return binarySearchRow(data[(top + bottom) / 2], val, left, right, (top + bottom) / 2);
        if ((left + right)/ 2 != 0 && searchCol(data, (left + right) / 2, top, bottom, val)[0] != -1 )
        {
            return searchCol(data, (left + right) / 2, top, bottom, val);
        }
        int centerVal = data[(top + bottom) / 2][(left + right) / 2];
        if (val > centerVal)
        {
            if (threeQuarterSearch(data, left, (left + right) / 2, top, (top + bottom) / 2, val)[0] != -1)
                return threeQuarterSearch(data, left, (left + right) / 2, top, (top + bottom) / 2, val);
            if (threeQuarterSearch(data, left, (left + right) / 2, (top + bottom) / 2, bottom, val)[0] != -1)
                return threeQuarterSearch(data, left, (left + right) / 2, (top + bottom) / 2, bottom, val);
            if (threeQuarterSearch(data, (left + right) / 2, right, top, (top + bottom) / 2, val)[0] != -1)
                return threeQuarterSearch(data, (left + right) / 2, right, top, (top + bottom) / 2, val);
        }
        if (val < centerVal)
        {
            if (threeQuarterSearch(data, (left + right) / 2, right, (top + bottom) / 2, bottom, val)[0] != -1)
                return threeQuarterSearch(data, (left + right) / 2, right, (top + bottom) / 2, bottom, val);
            if (threeQuarterSearch(data, left, (left + right) / 2, (top + bottom) / 2, bottom, val)[0] != -1)
                return threeQuarterSearch(data, left, (left + right) / 2, (top + bottom) / 2, bottom, val);
            if (threeQuarterSearch(data, (left + right) / 2, right, top, (top + bottom) / 2, val)[0] != -1)
                return threeQuarterSearch(data, (left + right) / 2, right, top, (top + bottom) / 2, val);
        }
        return new int[] {-1, -1};
    }
    /*
     * searches the row it is acted upon, using binary search
     * 
     * @param data the 2D array to be searched
     * @param left the left bound of the search
     * @param right the right bound of the search
     * @param val the value to be searched for by the algorithm
     * @param row the row that is being searched
     * 
     * @return returns -1, -1 if the val not found, else the coordinates of the val in the array.
     */
    public static int[] binarySearchRow(int[] data, int val, int left, int right, int row)
    {
        if (left >= right)
            return new int[] {-1, -1};
        int mid = (left + right) / 2;
        if (data[mid] == val)
            return new int[] {mid, row};
        else if (data[mid] < val)
            return binarySearchRow(data, val, mid + 1, right, row);
        else
            return binarySearchRow(data, val, left, mid - 1, row);
    }
    /*
     * Searches the column it is acted upon, value by value.
     * 
     * @param data the 2D array to be searched
     * @param col the column being searched by the method
     * @param row the row of the column being searched
     * @param bottom the lower bound of the search
     * @param val the value to be searched for by the algorithm
     * 
     * @return returns the coordinates of the value in the array, otherwise -1,-1
     */
    public static int[] searchCol(int[][] data, int col, int row, int bottom, int val)
    {
        if (row == bottom)
        {
            return new int[] {-1, -1};
        }
        if (data[row][col] == val)
        {
            return new int[] {col, row};
        }
        return searchCol(data, col, row + 1, bottom, val);
    }

    public static void main(String[] args)
    {
        int[][] board = getRandomSorted2DArray(3);
        print2D(board);
        System.out.println("( " + threeQuarterSearch(board, 0, board.length, 0, board[0].length, 56)[0] + "," + threeQuarterSearch(board, 0, board.length, 0, board[0].length, 56)[1] + ")");
    }
}