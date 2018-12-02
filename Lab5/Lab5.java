/**
The application class for Lab5.
The class just has the main method to use A and B.
It also uses class Object. Foll the directions in
all of the comments. Note that some of the steps are
done for you. 
*/

public class Lab5
{

   public static void main(String arg[])
   {
      // Declare a variable obj of class Object 
      Object obj; // (done for you)

      // Declare a variable objA of class A 
      A objA; // (done for you)

      // Declare two variables objB1 and objB2 of class B 
      B objB1, objB2; // (done for you)

      // Create an instance of A with value 10 and assign it to obj
      // Determine which SOP statements should be commented out.
      obj = new A(10); // (done for you) 

      // Now you're on your own!

      System.out.println("1. Yes, I can assign an instance of A to obj");
      //System.out.println("1. No, I can not assign an instance of A to obj");
      
      // Create an instance of class Object with the default constructor
      // and assign it to objA with or without casting
      // Determine which SOP statement should be commented out.
      
      //objA = new Object();  // this may or may not work
      //objA = new (A)Object(); // this may or may not work

      //System.out.println("2. Yes, I can assign an instance of class Object "
            //+ "to objA");

      //System.out.println("2. No, I can not assign an instance of class Object "
           // + "to objA");

      // Create an instance of A with value 5 and assign it to objA
      objA = new A(5);

      // Display a message for obj in the format
      // obj is: toString() for obj
      System.out.println("3. obj is: " + obj.toString()); // (done for you)

      // Display a message for objA in the format
      // 4. objA is: toString() for objA


      // Decide if obj and objA point to the same object
      // and comment out the incorrect statement:
      System.out.println("5. obj and objA point to the same object.");
      //System.out.println("5. obj and objA point to different objects.");

      System.out.println("6. Because obj == objA is: " + (obj == objA));

      // Decide if obj and objA have the same value and
      // comment out the incorrect SOP statement:
      //System.out.println("7. obj and objA have the same value.");
      System.out.println("7. obj and objA have different values.");

      System.out.println("8. Because objA.equals(obj) is: "
            + (objA.equals(obj)));

      // Call update on objA with value 5
      objA.update(5);

      // Display a message for obj in the format
      // 9. obj is: toString() for obj
      System.out.println("9. obj is: " + obj.toString());

      // Display a message for objA in the format
      // 10. objA is: toString() for objA
      System.out.println("9. objA is: " + objA.toString());

      // Decide if obj and objA point to the same object
      // and comment out the incorrect SOP statement:
      //System.out.println("11. obj and objA point to the same object.");
      System.out.println("11. obj and objA point to different objects.");

      System.out.println("12. Because obj == objA is: " + (obj == objA));

      // Decide if obj and objA have the same value and
      // comment out the incorrect SOP statement
      System.out.println("13. obj and objA have the same value.");
      //System.out.println("13. obj and objA have different values.");

      System.out.println("14. Because obj.equals(objA) is: "
            + (obj.equals(objA)));

      // Decide if objA and obj have the same value and
      // comment out the incorrect SOP statement:
      System.out.println("15. objA and obj have the same value.");
      //System.out.println("15. objA and obj have different values.");

      System.out.println("16. Because objA.equals(obj) is: "
            + (objA.equals(obj)));


      // Cast obj to A and assign it to objA and
      // comment out the incorrect SOP statement
      // Recall the syntax for an explicit cast: objOfTypeA = (TypeA)(someOtherObject);
      objA = (A)(obj);

      System.out.println("17. Yes, I can cast obj to A and assign it"
            + " to objA");
      //System.out.println("17. No, I can not cast obj to A and assign it"
           // + " to objA");


      // Display a message for obj in the format
      // 18. obj is: toString() for obj
      System.out.println("18. obj is: " + obj.toString());

      // Display a message for objA in the format
      // 19. objA is: toString() for objA
      System.out.println("18. objA is: " + objA.toString());

      // Decide if obj and objA point to the same object
      // and comment out the incorrect SOP statement:
      System.out.println("20. obj and objA point to the same object.");
      //System.out.println("20. obj and objA point to different objects.");

      System.out.println("21. Because obj == objA is: " + (obj == objA));

      // Decide if obj and objA have the same value and
      // comment out the incorrect SOP statement:
      System.out.println("22. obj and objA have the same value.");
      //System.out.println("22. obj and objA have different values.");

      System.out.println("23. Because obj.equals(objA) is: "
            + (obj.equals(objA)));


      // Create an instance of class B with values 10 and 0.5F
      // and assign it to objB1
      objB1 = new B(10,0.5F);

      // Display a message for objB1 in the format
      // 24. objB1 is: toString() for objB1
      System.out.println("24. objB1 is : " + objB1.toString());

      // Display a message for objA in the format
      // 25. objA is: toString() for objA
      System.out.println("25. objA is : " + objA.toString());

      // Decide if objB1 and objA point to the same object
      // and comment out the incorrect SOP statement:
      //System.out.println("26. objB1 and objA point to the same object.");
      System.out.println("26. objB1 and objA point to different objects.");

      System.out.println("27. Because objB1 == objA is: " + (objB1 == objA));

      // Decide if objB1 and objA have the same value and
      // comment out the incorrect SOP statement:
      //System.out.println("28. objB1 and objA have the same value.");
      System.out.println("28. objB1 and objA have different values.");

      System.out.println("29. Because objB1.equals(objA) is: "
            + (objB1.equals(objA)));

      // Decide if objA and objB1 have the same value and
      // comment out the incorrect SOP statement:
      System.out.println("30. objA and objB1 have the same value.");
      //System.out.println("30. objA and objB1 have different values.");

      System.out.println("31. Because objA.equals(objB1) is: "
            + (objA.equals(objB1)));


      // Create an object of B with values 0 and 0.5F and
      // assign it to objB2
      objB2 = new B(0,0.5F);

      // Display a message for objB1 in the format
      // 32. objB1 is: toString() for objB1
      System.out.println("32. objB1 is: " + objB1.toString());

      // Display a message for objB2 in the format
      // 33. objB2 is: toString() for objB2
      System.out.println("33. objB2 is: " + objB2.toString());

      // Decide if objB1 and objB2 point to the same object
      // and comment out the incorrect SOP statement:
      //System.out.println("34. objB1 and objB2 point to the same object.");
      System.out.println("34. objB1 and objB2 point to different objects.");

      System.out.println("35. Because objB1 == objB2 is: " + (objB1 == objB2));

      // Decide if objB1 and objB2 have the same value and
      // comment out the incorrect SOP statement:
      //System.out.println("36. objB1 and objB2 have the same value.");
      System.out.println("36. objB1 and objB2 have different values.");

      System.out.println("37. Because objB1.equals(objB2) is: "
                       + (objB1.equals(objB2)));

      // Call method update on objB2 with value 5
      objB2.update(5);

      // Display a message for objB1 in the format
      // 38. objB1 is: toString() for objB1
      System.out.println("38. objB1 is: " + objB1.toString());

      // Display a message for objB2 in the format
      // 39. objB2 is: toString() for objB2
      System.out.println("39. objB2 is: " + objB2.toString());

      // Decide if objB1 and objB2 point to the same object
      // and comment out the incorrect SOP statement:
      //System.out.println("40. objB1 and objB2 point to the same object.");
      System.out.println("40. objB1 and objB2 point to different objects.");

      System.out.println("41. Because objB1 == objB2 is: " + (objB1 == objB2));

      // Decide if objB1 and objB2 have the same value and
      // comment out the incorrect SOP statement:
      System.out.println("42. objB1 and objB2 have the same value.");
      //System.out.println("42. objB1 and objB2 have different values.");

      System.out.println("43. Because objB1.equals(objB2) is: "
            + (objB1.equals(objB2)));


      // Call method updateY on objB2 with value 0.1F
      objB2.updateY(0.1F);

      // Display a message for objB1 in the format
      // 44. objB1 is: toString() for objB1
      System.out.println("44. objB1 is: " + objB1.toString());

      // Display a message for objB2 in the format
      // 45. objB2 is: toString() for objB2
      System.out.println("45. objB2 is: " + objB2.toString());

      // Decide if objB1 and objB2 point to the same object
      // and comment out the incorrect SOP statement:
      //System.out.println("46. objB1 and objB2 point to the same object.");
      System.out.println("46. objB1 and objB2 point to different objects.");

      System.out.println("47. Because objB1 == objB2 is: " + (objB1 == objB2));

      // Decide if objB1 and objB2 have the same value and
      // comment out the incorrect SOP statement:
      //System.out.println("48. objB1 and objB2 have the same value.");
      System.out.println("48. objB1 and objB2 have different values.");

      System.out.println("49. Because objB1.equals(objB2) is: "
            + (objB1.equals(objB2)));

      // Assign objB1 to objB2
      objB2 = objB1; // (done for you)

      // Assign objB1 to objA
      objA = objB1;


      // Display a message for objA in the format
      // 50. objA is: toString() for objA
      System.out.println("50. objA is: " + objA.toString());

      // Display a message for objB2 in the format
      // 51. objB2 is: toString() for objB2
      System.out.println("51. objB2 is: " + objB2.toString());

      // Decide if objA and objB2 point to the same object
      // and comment out the incorrect SOP statement:
      System.out.println("52. objA and objB2 point to the same object.");
      //System.out.println("52. objA and objB2 point to different objects.");

      System.out.println("53. Because objA == objB2 is: " + (objA == objB2));

      // Decide if objA and objB2 have the same value and
      // comment out the incorrect SOP statement
      System.out.println("54. objA and objB2 have the same value.");
      //System.out.println("54. objA and objB2 have different values.");

      System.out.println("55. Because objA.equals(objB2) is: "
            + (objA.equals(objB2)));

      // Decide if objB2 and objA have the same value and
      // comment out the incorrect SOP statement:
      System.out.println("56. objB2 and objA have the same value.");
      //System.out.println("56. objB2 and objA have different values.");

      System.out.println("57. Because objB2.equals(objA) is: "
            + (objB2.equals(objA)));

      // Call updateY on objB2 with 0.5F
      objB2.updateY(0.5F);

      // Display a message for objA in the format
      // 58. objA is: toString() for objA
      System.out.println("58. objA is: " + objA.toString());

      // Display a message for objB2 in the format
      // 59. objB2 is: toString() for objB2
      System.out.println("59. objB2 is: " + objB2.toString());

      // Decide if objA and objB2 point to the same object
      // and comment out the incorrect SOP statement:
      System.out.println("60. objA and objB2 point to the same object.");
      //System.out.println("60. objA and objB2 point to different objects.");

      System.out.println("61. Because objA == objB2 is: " + (objA == objB2));

      // Decide if objA and objB2 have the same value and
      // comment out the incorrect SOP statement:
      System.out.println("62. objA and objB2 have the same value.");
      //System.out.println("62. objA and objB2 have different values.");

      System.out.println("63. Because objA.equals(objB2) is: "
            + (objA.equals(objB2)));

      // Call updateY on objA with 0.5F without casting
      // Decide which SOP statement needs to be commented out accordingly
      //objA.updateY(0.5F);
      
      //System.out.println("64. Yes, updateY can be called on objA.");
      System.out.println("64. No, updateY can not be called on objA.");

      // Call updateY on objA with 0.5F with casting
      // Decide which SOP statement needs to be commented out accordingly
      ((B)objA).updateY(0.5F);

      System.out.println("65. Yes, updateY can be called on objA after casting.");
      //System.out.println("65. No, updateY can not be called on objA after casting.");

      // Display a message for objA in the format
      // 66. objA is: toString() for objA
      System.out.println("66. objA is: " + objA.toString());

      // Display a message for objB2 in the format
      // 67. objB2 is: toString() for objB2
      System.out.println("67. objB2 is: " + objB2.toString());

      // Decide if objA and objB2 point to the same object
      // and comment out the incorrect SOP statement
      System.out.println("68. objA and objB2 point to the same object.");
      //System.out.println("68. objA and objB2 point to different objects.");

      System.out.println("69. Because objA == objB2 is: " + (objA == objB2));

      // Decide if objA and objB2 have the same value and
      // comment out the incorrect SOP statement
      System.out.println("70. objA and objB2 have the same value.");
      //System.out.println("70. objA and objB2 have different values.");

      System.out.println("71. Because objA.equals(objB2) is: "
            + (objA.equals(objB2)));
   }
}
