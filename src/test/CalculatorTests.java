
package test;

import static org.junit.Assert.*;
import org.junit.*;
import app.*;

public class CalculatorTests {
    @Test
    public void zeroOnEmptyString() {
        assertEquals(0,StringCalculator.add(""));
    }

    @Test
    public void numberItselfOnOneNumber() {
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void returnSumOfNumbers() {
        assertEquals(5, StringCalculator.add("2,3"));
    }

    @Test
    public void handleSumOfMultipleNumbers() {
        assertEquals(9, StringCalculator.add("2,3,4"));
    }

    @Test
    public void handleMultipleDelimiters() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void handleCustomDelimiters() {
        assertEquals(10, StringCalculator.add("//$\n1$2$3$4"));
    }

    @Test
    public void throwErrorOnNegativeNumber() {
        try{
            StringCalculator.add("-2,3,3");
            fail();
        }
        catch(RuntimeException e){
            assertEquals("negatives not allowed : -2", e.getMessage());
        }
    }

    @Test
    public void throwErrorOnMultipleNegativeNumber() {
        try{
            StringCalculator.add("-1,-2,3");
            fail();
        }
        catch(RuntimeException e){
            assertEquals("negatives not allowed : -1 -2", e.getMessage());
        }
    }

    @Test
    public void ignoreNumberGreaterThanThousand() {
        assertEquals(5, StringCalculator.add("2,3,1002"));
    }

    @Test
    public void handleCustomDelimiterOfAnyLength() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void handleMultipleCustomDelimiter() {
        assertEquals(6, StringCalculator.add("//[*][$]\n1$2*3"));
    }

    @Test
    public void handleMultipleCustomDelimiterOfAnyLength() {
        assertEquals(6, StringCalculator.add("//[**][$$]\n1$$2**3"));
    }


}
