import java.util.Scanner;


public class Lab2
{ 
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      
      
      System.out.print("Enter number of rows: ");
      int rows = input.nextInt();
      System.out.print("Enter number of columns: ");
      int cols = input.nextInt();
      System.out.print("Enter start row: ");
      int startRow = input.nextInt();
      System.out.print("Enter start column: ");
      int startCol = input.nextInt();
      
      System.out.println();
      
      SelfAvoidingRandomWalk walk = new SelfAvoidingRandomWalk(rows, cols, startRow, startCol);
      while (walk.canTakeStep() == true)
      {
        walk.step();
        walk.print();
      }
        
      walk.print();
      System.out.println();
      System.out.println("Length of Path = " + walk.length());

      
   }





}
