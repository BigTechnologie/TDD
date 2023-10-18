package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    private FizzBuzz f;

    @BeforeEach
    public void setup() {
        f = new FizzBuzz();
    }

    // TDD
    // 1: On écrit le test, ici on vérifie que pour un nombre non divisible par 3 et par 5
    // la méthode convert va retourner le nombre convertie en chaine de caractère
    // On ajoute unique dans le code nécessaire (la classe, la méthode vide)
    // 2: On éxecute le test => Il doit échouer, pour vérifier que le test est valide (car le code qu'il teste n'existe pas)
    @Test
    public void nombreNonModifie1Test() {
        assertEquals("1", f.convert(1));
    }

    @Test
    public void nombreNonModifie4Test() {
        assertEquals("4", f.convert(4));
    }

    // Test si pour un nombre divisible 3, la méthode convert retourne "Fizz"
    @Test
    public void nombreMultiple3Test() {
        assertEquals("Fizz", f.convert(6));
    }

    // Test si pour un nombre divisible 5, la méthode convert retourne "Buzz"
    @Test
    public void nombreMultiple5Test() {
        assertEquals("Buzz", f.convert(10));
    }

    // Test si pour un nombre divisible 3 et par 5, la méthode convert retourne "FizzBuzz"
    @Test
    public void nombreMultiple3et5Test() {
        assertEquals("FizzBuzz", f.convert(15));
    }

    // Test si pour un nombre contient 3, la méthode convert retourne "Fizz"
    @Test
    public void nombreContient3Test() {
        assertEquals("Fizz", f.convert(13));
    }

    // Test si pour un nombre contient 5, la méthode convert retourne "Buzz"
    @Test
    public void nombreContient5Test() {
        assertEquals("Buzz", f.convert(52));
    }

    // Test si pour un nombre contient 3 et 5, la méthode convert retourne "FizzBuzz"
    @Test
    public void nombreContient5et3Test() {
        assertEquals("FizzBuzz", f.convert(53));
    }

    // Test si pour un nombre est égal à 0, la méthode convert retourne "0"
    @Test
    public void nombreZeroTest() {
        assertEquals("0", f.convert(0));
    }
}
