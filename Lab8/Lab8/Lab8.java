import java.util.*;
import java.io.*;

public class Lab8
{

    public static void main(String args[])
    {
        int intSum = 0;
        double doubleSum = 0;
        Scanner in = null;
        PrintWriter outInt = null;
        PrintWriter outDoub = null;
        if (args.length < 3)
        {

            return;
        }
        try {
            in = new Scanner(new File(args[0]));
            outInt = new PrintWriter(new File(args[1]));
            outDoub = new PrintWriter(new File(args[2]));
            while (in.hasNextDouble() || in.hasNextInt())
                if (in.hasNextInt())
                {
                    intSum += in.nextInt();
                }
                else if (in.hasNextDouble())
                {
                    doubleSum += in.nextDouble();
                }
            outDoub.print(doubleSum);
            outInt.print(intSum);
        }
        catch (Exception ex)
        {
            System.out.println("File not found");
        }
        finally
        {
            if (in != null)
                in.close();
            if (outInt != null)
                outInt.close();
            if (outDoub != null)
                outDoub.close();
        }
    
    
    
    
    
    
    
    } // main
} // Lab8