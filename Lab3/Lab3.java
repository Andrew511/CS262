import java.util.Scanner;
/**
 * Write a description of class Lab3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lab3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String toBeReversed = in.next();
        System.out.println(reverse2(toBeReversed));
    }
    
    public static String reverse2(String str)
    {
        if (str.length() == 0)
            return str;
        return str.charAt(str.length() - 1) + reverse2(str.substring(str.length() / 2,str.length() - 1)) + reverse2(str.substring(0,str.length() / 2)) ;
    }
}
