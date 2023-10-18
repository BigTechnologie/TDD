package fr.dawan.formationtdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeapYearTest {

    @Test
    public void anneeNonBissextileTest() {
        assertFalse(LeapYear.isLeapYear(2023));
    }

    @Test
    public void divisiblePar4Test() {
        assertTrue(LeapYear.isLeapYear(2024));
    }

    @Test
    public void divisiblePar100Test() {
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void divisiblePar400Test() {
        assertTrue(LeapYear.isLeapYear(2000));
    }

}
