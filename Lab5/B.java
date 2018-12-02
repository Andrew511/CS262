/**
A base class to demo inheritance.
It has a constructor and a simple update method.
The class also overrides toString and equals methods from class Object.
*/

// DO NOT MODIFY ANY OF THIS CODE!

public class B extends A
{
   // Additional data
   private float yValue;

   /**
   Constructor with two parameters.
   @param x the initial value for xValue
   @param y the initial value for yValue
   */
   public B (int x, float y)
   {
      super(x);
      yValue = y;
   }

   /**
   Overrides the update method from A.
   It adds twice the amount of the parameter to xValue
   Make sure the comment style is also correct.
   */
   @Override
   public void update(int x)
   {
      xValue += 2 * x;
   }
   /**
   Overrides method toString from A.
   @return string with both xValue and yValue
      example: xValue: 13   yValue: 3.52
   */
   @Override
   public String toString()
   {
      return "xValue: " + xValue + "   yValue: " + yValue;
   }

   /**
   Overrides method equals from A.
   The method returns true if obj is an instance of B
   with the same xValue and yValue, and false otherwise.
   Make sure the comment style is also correct.
   */
    @Override
   public boolean equals( Object obj )
   {
      if (obj instanceof B)
      {
         B temp = (B) obj;
         if (temp.xValue == this.xValue && temp.yValue == this.yValue)
            return true;
      }
      return false;
   }

   /**
   Updates yValue by adding f to it.
   @param f the value to add to yValue
   */
   public void updateY(float f)
   {
      yValue += f;
   }
}
