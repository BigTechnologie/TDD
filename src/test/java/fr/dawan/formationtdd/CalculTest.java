package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test de la classe Calcul")
//@Disabled // @Disabled sur la classe => Pour désactiver tous les tests de la classe
public class CalculTest {

    private Calcul calcul;

    // -> Setup
    @BeforeAll
    public static void setup() {
        System.out.println("Before All -> executer une fois avant tous les tests de la classe");
    }

    @BeforeEach
    public void init() {
        System.out.println("Before Each -> executer avant chaque test");
        calcul = new Calcul(); // avant chaque test l'objet calcul est recréé
    }

    @Test // @Test=> permet de définir la méthode comme un cas de test
    @DisplayName("Test de la méthode addition") // @DisplayName => permet de renommer le test, sinon le test a pour nom,
                                                // le nom de la méthode
    public void additionTest() {
        int res = calcul.addition(2, 4); // -> Exercice
        assertEquals(6, res); // -> Vérification
        // Les assertions permettent de faire des vérifications, si elle échoue le test échoue
        // Dans les assertions:
        // - le premier paramètre est la valeur attendu
        // - le 2ème paramètre est la valeur retournée par la méthode à tester
        // - Toutes les assertions de junit peuvent avoir un troisième paramètre qui est un message afficher quand le test échoue
    }

    // avec Junit 5, la méthode n'a pas besoin d'être public, elle peut avoir une visibilté de package
    @Test
    void divisionTest() {
        double res = calcul.division(6.0, 2.0);
        assertEquals(3.0, res);
    }

    @Test
    public void divisionZeroTest() {
        assertThrows(ArithmeticException.class, () -> calcul.division(3.0, 0.0));
        // => assertThrows permet de verifier que la méthode lance une exception
        // - Le premier paramètre est l'exception attendue
        // - Le 2ème paramètre est une expression lambda qui permet d'executer la méthode à tester
//        try {
//            calcul.division(3.0, 0.0);
//            fail();
//        } catch (ArithmeticException e) {
//            assertTrue(true);
//        }
    }

    @Test
    @Disabled // => désactiver un test
    public void nePasExecuter() {

    }

    // -> Teardown
    @AfterEach
    public void clean() {
        System.out.println("After Each -> executer après chaque test");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("AfterAll -> executer une fois après tous les tests de la classe");
    }
}
