package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

// Convention de nommage par défaut des tests avec Maven
// - Test unitaire: plugin surefire
//  Toutes les classes qui commencent par TEST ou qui finissent par Test, Tests ou TestCase
//
// - Test d'intégration: plugin failsafe
//  Toutes les classes qui commencent par IT ou qui finissent par IT ou ITCase
public class ExempleIT {

    @Test
    public void testIT() {
        fail();
    }
}
