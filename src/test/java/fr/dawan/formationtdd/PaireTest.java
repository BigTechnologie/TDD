package fr.dawan.formationtdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Pair ou impair
//On passe un nombre paramètre variable de type entier à une méthode et  on veut déterminer si la somme de tous les nombres est paire ou impaire
//- La réponse est retournée sous la forme d'une chaîne (impair ou pair)
//- S'il n'y a pas de paramètre, on retourne paire
public class PaireTest {

    private Paire paire;

    @BeforeEach
    public void setup() {
        paire = new Paire();
    }

    @Test
    public void paritePairTest() {
        String res = paire.parite(1, 3, 4);
        assertEquals("pair", res);
    }

    @Test
    public void pariteImpairTest() {
        assertEquals("impair", paire.parite(1, 2));
    }

    @Test
    public void paraiteNoParam() {
        assertEquals("pair", paire.parite());
    }
}
