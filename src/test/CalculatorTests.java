
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
}
