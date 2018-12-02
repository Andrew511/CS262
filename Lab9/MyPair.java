
/**
 * Write a description of class MyPair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyPair<T>
{
    T x;
    T y;
    public MyPair(T inX, T inY)
    {
        x = inX;
        y = inY;
    }

    public T getX()
    {
        return this.x;
    }

    public T getY()
    {
        return y;
    }

    public void setX(T inX)
    {
        x = inX;
    }

    public void setY(T inY)
    {
        y = inY;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
    
    public static MyPair swap(MyPair toBeSwapped)
    {
        return new MyPair(toBeSwapped.y,toBeSwapped.x);
    }
    
    public static void main(String args[])
    {
        MyPair<Integer> my1 = new MyPair<Integer>(1 , 2);
        MyPair<String> my2 = new MyPair<String>("Hello", "World");
        System.out.println(my1.getX());
        System.out.println(my1.getY());
        System.out.println(my1.toString());
        my1.setX(3);
        System.out.println(my1.toString());
        System.out.println(swap(my1).toString());
        System.out.println(my2.toString());
        System.out.println(swap(my2).toString());
    }
    
    
}
