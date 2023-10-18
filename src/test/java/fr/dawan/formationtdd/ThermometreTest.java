package fr.dawan.formationtdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThermometreTest {

    private Thermometre thermometre;

    @BeforeEach
    public void setup() {
        thermometre = new Thermometre();
    }

    @Test
    public void pasDeTemperatureTest() {
        assertEquals(0, thermometre.procheZero());
    }

    @Test
    public void nombreTemperatureSup100Test() {
        int t[] = new int[101];
        assertThrows(IllegalArgumentException.class, () -> thermometre.procheZero(t));
    }

    @Test
    public void procheZeroTemperatureTest() {
        assertEquals(2, thermometre.procheZero(2, 4, 6, 3, -7, -3));
        assertEquals(-2, thermometre.procheZero(-3, 5, -6, -2, 4));
    }

    @Test
    public void procheZeroPositifTemperatureTest() {
        assertEquals(2, thermometre.procheZero(-2, 4, 6, -7, 2));
    }

}
