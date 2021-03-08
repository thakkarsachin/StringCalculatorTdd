
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
}
