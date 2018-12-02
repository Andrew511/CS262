// DO NOT MODIFY ANY OF THIS CODE!
public class A
{

   protected int xValue;

   /**
   Constructor with one parameter.
   @param x the initial value for xValue
    */
   public A(int x)
   {
      xValue = x;
   }

   /**
   Updates xValue by adding x to it.
   @param x the value to add to xValue
    */
   public void update(int x)
   {
      xValue += x;
   }

   /**
   Overrides method toString from class Object.
   @return string "xValue: " followed by xValue
   example: xValue: 13
    */
   @Override
   public String toString()
   {
      return "xValue: " + xValue;
   }

   /**
   Overrides method equals from class Object.
   @param obj the object to compare with
   @return true if obj is an instance of A with the same xValue
   false otherwise
    */
   @Override
   public boolean equals(Object obj)
   {
      if (obj instanceof A)
      {
         A temp = (A) obj;
         if (temp.xValue == this.xValue)
         {
            return true;
         }
      }
      return false;
   }
}
