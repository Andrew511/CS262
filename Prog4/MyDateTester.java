
import p1.MyDate;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MyDateTester. Tests MyDate classes to see if they can handle situations that they can be expected to recieve.
 *
 * @author  Andrew Wrege
 * @version 11/27/16
 */
public class MyDateTester
{
    private final int[] DAYS_IN_EACH_MONTH_NOT_LEAP = {31,28,31,30,31,30,31,31,30,31,30,31};
    MyDate expected, actual;
    /*
     * Tests if Tomorrow increments days by one
     */
    @Test
    public void tomorrowTest()
    {
        expected = new MyDate(1,2,0);
        actual = new MyDate(1,1,0);
        actual = actual.tomorrow();
        assertTrue("actual=" + actual.toString() + ", expected=" + expected.toString(), actual.compareTo(expected) == 0);
    }
    /*
     * Tests if appropraite months have 31 day in them
     */
    @Test
    public void thirtyOneDayMonthTest()
    {
        for (int i = 1; i <= 12; i++)
        {
            if (DAYS_IN_EACH_MONTH_NOT_LEAP[i - 1] == 31) 
            {
                actual = new MyDate (i,30,0);
                int expected = 31;
                actual = actual.tomorrow();
                assertTrue("actual=" + actual.getDay() + ", expected=" + expected, actual.getDay() == expected);
            }
        }
    }
    /*
     * tests if appropriate months have 30 days in them
     */
    @Test
    public void thirtyDayMonthTest()
    {
        for (int i = 1; i <= 12; i++)
        {
            if (DAYS_IN_EACH_MONTH_NOT_LEAP[i - 1] == 30) 
            {
                actual = new MyDate (i,29,0);
                int expected = 30;
                actual = actual.tomorrow();
                assertTrue("actual=" + actual.getDay() + ", expected=" + expected, actual.getDay() == expected);
            }
        }
    }
    /*
     * tests if tomorrow() rolls over to a new month when its days are exceeded
     */
    @Test
    public void newMonthTest()
    {
        actual = new MyDate(1,31,0);
        expected = new MyDate(2,1,0);
        actual = actual.tomorrow();
        assertTrue("actual=" + actual.toString() + ", expected=" + expected.toString(), actual.compareTo(expected) == 0);
    }
    /*
     * Tests if tomorrow() rolls over to a new year when months are exceeded
     */
    @Test
    public void newYearTest()
    {
        actual = new MyDate(12,31,0);
        expected = new MyDate(1,1,1);
        actual = actual.tomorrow();
        assertTrue("actual=" + actual.toString() + ", expected=" + expected.toString(), actual.compareTo(expected) == 0);
    }
    /*
     * Tests if compareto returns -1 when it is smaller than the compared day
     */
    @Test
    public void compareToGreaterDayTest()
    {
        actual = new MyDate(1,2,0);
        int expected = -1;
        MyDate greater = new MyDate(1,3,0);
        assertTrue("actual=" + actual.compareTo(greater) + ", expected=" + expected, actual.compareTo(greater) == expected);
    }
    /*
     * tests if compareto returns 1 when it is larger than the compared day
     */
    @Test
    public void compareToLesserDayTest()
    {
        actual = new MyDate(1,2,0);
        int expected = 1;
        MyDate lesser = new MyDate(1,1,0);
        assertTrue("actual=" + actual.compareTo(lesser) + ", expected=" + expected, actual.compareTo(lesser) == expected);
    }
    /*
     * tests if compare to returns 0 when the dates are equal
     */
    @Test
    public void compareToEqualTest()
    {
        actual = new MyDate(1,2,0);
        int expected = 0;
        MyDate equal = new MyDate(1,2,0);
        assertTrue("actual=" + actual.compareTo(equal) + ", expected=" + expected, actual.compareTo(equal) == expected);
    }
    /*
     * Tests if compareto returns -1 when it is smaller than the compared month
     */
    @Test
    public void compareToGreaterMonthTest()
    {
        actual = new MyDate(1,1,0);
        int expected = -1;
        MyDate greater = new MyDate(2,1,0);
        assertTrue("actual=" + actual.compareTo(greater) + ", expected=" + expected, actual.compareTo(greater) == expected);
    }
    /*
     * tests if compareto returns 1 when it is larger than the compared month
     */
    @Test
    public void compareToLesserMonthTest()
    {
        actual = new MyDate(2,1,0);
        int expected = 1;
        MyDate lesser = new MyDate(1,1,0);
        assertTrue("actual=" + actual.compareTo(lesser) + ", expected=" + expected, actual.compareTo(lesser) == expected);
    }
    /*
     * Tests if compareto returns -1 when it is smaller than the compared year
     */
    @Test
    public void compareToGreaterYearTest()
    {
        actual = new MyDate(1,1,0);
        int expected = -1;
        MyDate greater = new MyDate(1,1,1);
        assertTrue("actual=" + actual.compareTo(greater) + ", expected=" + expected, actual.compareTo(greater) == expected);
    }
    /*
     * tests if compareto returns 1 when it is larger than the compared year
     */
    @Test
    public void compareToLesserYearTest()
    {
        actual = new MyDate(1,1,1);
        int expected = 1;
        MyDate lesser = new MyDate(1,1,0);
        assertTrue("actual=" + actual.compareTo(lesser) + ", expected=" + expected, actual.compareTo(lesser) == expected);
    }
    /*
     * Tests if on all leap years that the 29th is the last day of february
     */
    @Test
    public void leapYearFebruaryLastDayTest()
    {
        final int EVERY_FOUR = 4;
        final int HUNDRED = 100;
        final int FOUR_HUNDRED = 400;
        boolean expected = true;
        for (int i = 4; i < 3000; i++)
        {
            if (i / EVERY_FOUR == 0 && !(i / HUNDRED == 0 && i / FOUR_HUNDRED != 0))
            {
                actual = new MyDate(2,29,i);
                assertTrue("actual=" + actual.isLastDayOfMonth() + " expected=" + expected + " year=" + i, actual.isLastDayOfMonth() == expected);
            }
        }
    }
    /*
     * tests that the last day is correct for every month of the year
     */
    @Test
    public void lastDaysOfMonthsNotLeap()
    {
        
        for (int i = 1; i <= 12; i++)
        {
            actual = new MyDate(i,DAYS_IN_EACH_MONTH_NOT_LEAP[i - 1],0);
            boolean expected = true;
            assertTrue("actual=" + actual.isLastDayOfMonth() + " expected=" + expected, actual.isLastDayOfMonth() == expected);
        }
    }
    /*
     * tests if a day that should not be the last day of the month returns as the last day
     */
    @Test
    public void testForFalseLastDay()
    {
        actual = new MyDate(1,1,1);
        boolean expected = false;
        assertTrue("actual=" + actual.isLastDayOfMonth() + " expected=" + expected, actual.isLastDayOfMonth() == expected);
    }
    /*
     * tests if tostring returns in the correct format of M/D/Y
     */
    @Test
    public void toStringTest()
    {
        actual = new MyDate(1,2,3);
        String expected = "1/2/3";
        assertTrue("actual=" + actual.toString() + "expected=" + expected,expected.equals(actual.toString()));
    }
}
