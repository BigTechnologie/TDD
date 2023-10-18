package fr.dawan.formationtdd;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.endsWithIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import fr.dawan.formationtdd.beans.Personne;

// Le cycle de vie des instances de test 
// par défaut: Lifecycle.PER_METHOD -> Une nouvelle instance est créée pour exécuter chaque méthode de test

//@TestInstance(Lifecycle.PER_CLASS) -> Une seule instance est créée pour tous les tests d'une même classe
public class ExempleTest {

    public ExempleTest() {
        System.out.println("Constructeur par défaut");
    }

// avec Lifecycle.PER_CLASS -> @BeforeAll et @AfterAll les méthodes sont des méthodes d'instances
//    @BeforeAll
//    public void setUp() {
//        System.out.println("Setup");
//    }

    // Exemple d'assertion de Junit
    @Test
    @DisplayName("Assertion égalité tableau")
    public void processArrayTest() {
        double expected[] = { 4.5, 6.7, 1.2, 3.4, 100.0 };
        double[] result = Exemple.processArray();
        assertArrayEquals(expected, result, 0.0000001);
    }

    @Test
    @DisplayName("Assertion égalité collection")
    public void processIterableTest() {
        List<Integer> expected = Arrays.asList(1, 6, 3, 7);
        List<Integer> result = Exemple.processIterable();
        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("Assertion temps d'execution")
    public void processTimeTest() {
        // assertTimeout(Duration.ofMillis(400),()->Exemple.processTime());
        assertTimeoutPreemptively(Duration.ofMillis(400), () -> Exemple.processTime());
        // => assertTimeoutPreemptively arréte le test une fois la durée définie par l'assertion est dépasseé
    }

    @Test
    @DisplayName("Message d'assertion")
    @Disabled
    public void assetionMessageTest() {
        double expected[] = { 6.7, 1.2, 3.4, 100.0 };
        double[] result = Exemple.processArray();
        // Message dans les assertions (dernier paramètre)
        assertArrayEquals(expected, result, 0.0000001, "Le message d'assertion");
    }

    // Nombre d'assertion par méthode
    // – tester un seul concept par méthode de test
    // - minimiser le nombre d'assertion par concept
    @Test
    public void intervalLimitMinTest() {
        assertTrue(Exemple.interval(3, -4, 7));
        assertTrue(Exemple.interval(-4, -4, 7));
        assertFalse(Exemple.interval(-5, -4, 7));
    }

    @Test
    public void intervalLimitMaxTest() {
        assertTrue(Exemple.interval(3, -4, 7));
        assertTrue(Exemple.interval(7, -4, 7));
        assertFalse(Exemple.interval(8, -4, 7));
    }

    @Test
    @Disabled
    public void createDimensionTest() {
        assertEquals(200, Exemple.createDimension().width);
        // La deuxième assertion n'est pas éxécuté car la première a échoué
        assertEquals(300, Exemple.createDimension().height);
    }

    // Regrouper les assertions => assertAll
    // permet de regrouper plusieurs assertions qui seront toutes exécutées même si une des assertions du groupe échoue
    @Test
    @Disabled
    public void createDimension2Test() {
        assertAll("Dimmension non conforme", 
                () -> assertEquals(200, Exemple.createDimension().width),
                () -> assertEquals(300, Exemple.createDimension().height));
    }

    // Bibliothèques tiers d’assertions :Hamcrest

    // Avec Hamcrest, on utilise la seul assertion assertThat
    // on précise la valeur réel et le matcher approprié qui spécifie la valeur attendue hasToString -> tester toString
    @Test
    @Tag("HAMCREST")
    public void toStringPersonneTest() {
        assertThat(Exemple.createPersonne().toString(), hasToString("Personne [id=3, prenom=John, nom=Doe, dateNaissance=1989-06-10]"));
    }

    // instanceOf -> tester le type
    @Test
    @Tag("HAMCREST")
    public void instancePersonneTest() {
        assertThat(Exemple.createPersonne(), instanceOf(Personne.class));
    }

    // hasProperty -> tester les propriétés des JavaBeans
    @Test
    @Tag("HAMCREST")
    public void propertyPersonneTest() {
        // Tester si la propriétée nom est présente dans l'objet retourné par createPersonne
        assertThat(Exemple.createPersonne(), hasProperty("nom"));
        // Tester si la propriétée nom est présente dans l'objet retourné par createPersonne et si elle a la valeur Doe
        assertThat(Exemple.createPersonne(), hasProperty("nom", equalTo("Doe")));
    }

    // samePropertyValuesAs -> tester si toutes les propriétés ont la même valeur Le deuxième paramètre correspont aux attributs qui seront ignorés (ici id et prénom)
    @Test
    @Tag("HAMCREST")
    public void samePropertyPersoneTest() {
        Personne p1 = new Personne("Jane", "Doe", LocalDate.of(1989, 6, 10));
        // p1.setId(3L);
        assertThat(Exemple.createPersonne(), samePropertyValuesAs(p1, "id", "prenom"));
    }

    // endsWithIgnoringCase -> tester si la chaine retournée a pour sufixe RLD en ignorant la casse
    @Test
    @Tag("HAMCREST")
    public void stringTest() {
        assertThat(Exemple.createString(), endsWithIgnoringCase("RLD"));
    }

    // matchesPattern -> tester si la i la chaine retournée correspond à l'expression régulière
    @Test
    @Tag("HAMCREST")
    public void regexTest() {
        assertThat(Exemple.createString(), matchesPattern("[a-zA-Z ]+"));
    }

    // Test sur une collection
    @Test
    @Tag("HAMCREST")
    @Tag("COLLECTION")
    public void listTest() {
        assertThat(Exemple.createList(), hasSize(4)); // hasSize -> test si elle contient 4 éléments
        assertThat(Exemple.createList(), hasItem(23)); // hasItem -> test si elle contient l'élément 23
        assertThat(Exemple.createList(), hasItems(23, 6, 1)); // hasItems -> test si elle contient les éléments 23,6,1
        assertThat(Exemple.createList(), containsInAnyOrder(23, 6, 1, 4)); // containsInAnyOrder -> test si la liste contient exactement les valeurs 23,6,1,4 sans tenir compte de l'ordre
        assertThat(Exemple.createList(), containsInRelativeOrder(1, 6, 4, 23)); // containsInRelativeOrder -> idem containsInAnyOrder mais en tenant compte de l'ordre
        assertThat(Exemple.createList(), everyItem(lessThan(50))); // test pour tous les éléments de la liste sont ... ici < à 50
    }

    // Test sur une map
    @Test
    @Tag("HAMCREST")
    @Tag("COLLECTION")
    public void mapTest() {
        assertThat(Exemple.createMap(), hasKey(12));           // hasKey-> tester si une map contient une clé 
        assertThat(Exemple.createMap(), hasValue("Hello"));    // hasValue -> tester si une map contient une valeur
        assertThat(Exemple.createMap(), hasEntry(42, "Reponse")); // hasEntry -> tester si une map contient une entry
     }

    @Test
    @Tag("HAMCREST")
    public void operatorLogicalTest() {
        // allOf -> correspond si tous les matchers correspondent (équivalant à && en java)
        assertThat(Exemple.createString(), allOf(startsWith("He"), endsWith("ld")));
        // anyOf -> correspond si un des matchers correspont, (équivalant à || en java)
        assertThat(Exemple.createString(), anyOf(startsWith("He"), endsWith("nde")));
    }

    // Bibliothèques tiers d’assertions : AssertJ
    @Test
    public void stringAssertJTest() {
        Assertions.assertThat(Exemple.createString()).containsWhitespaces().containsAnyOf("H", "o", "y");
        Assertions.assertThat(Exemple.createString()).contains("lo", "l");
    }

    @Test
    @Tag("COLLECTION")
    public void listAssetJTest() {
        Assertions.assertThat(Exemple.createList()).isNotEmpty().as("La liste doit contenir 23 et 1").contains(23, 1);
        Assertions.assertThat(Exemple.createList()).filteredOn(e -> e > 2 && e < 7).containsExactly(6, 4);
    }

    // Bibliothèques tiers d’assertions : JSONassert
    // elle permet d'écrire des tests unitaires JSON avec moins de code
    @Test
    public void jsonTest() {
        String expected = "{\"id\":1, \"prenom\":\"Alan\"}";
        String expectedStrict = "{\"id\":1, \"prenom\":\"Alan\", \"nom\":\"Smithe\", \"dateNaissance\":[1991,3,14]}";
        try {
            // LENIENT -> si le JSON retourné par createJson contient des champs supplémentaire
            // comparé au JSON attendu le test réussira quand même
            JSONAssert.assertEquals(expected, Exemple.createJson(), JSONCompareMode.LENIENT);
            // STRICT -> si le JSON retourné par createJson et le JSON attendu doivent être identique
            JSONAssert.assertEquals(expectedStrict, Exemple.createJson(), JSONCompareMode.STRICT);
        } catch (JSONException e) {
            fail();
        }
    }

    @Test
    public void jsonArrayTest() {
        System.out.println(Exemple.createArrayJson());
        String expected = "[{\"id\":2,\"prenom\":\"Jane\",\"nom\":\"Doe\",\"dateNaissance\":[1996,3,10]},"
                + "{\"id\":1,\"prenom\":\"John\",\"nom\":\"Doe\",\"dateNaissance\":[1991,3,10]}]";
        
        String expectedStrict = "[{\"id\":1,\"prenom\":\"John\",\"nom\":\"Doe\",\"dateNaissance\":[1991,3,10]},"
                + "{\"id\":2, \"prenom\":\"Jane\",\"nom\":\"Doe\",\"dateNaissance\":[1996,3,10]}]";

        try {
            JSONAssert.assertEquals(expected, Exemple.createArrayJson(), JSONCompareMode.LENIENT);
            JSONAssert.assertEquals(expectedStrict, Exemple.createArrayJson(), JSONCompareMode.STRICT);
        } catch (JSONException e) {
            fail();
        }
    }

    // Assumption
    // Si l'évaluation d'une assumption échoue alors l'exécution du test est interrompue
    // Il est considéré comme désactivé
    @Test
    public void testAssumption() {
        // Quand on execute le test sous windows startsWith -> retourne true
        // L'assumption attend false, le test est interrompue
        assumeFalse(System.getenv("OS").startsWith("Windows"));
        fail(); // fail n'est pas executé, le test réussit
    }

    @Test
    public void assumingThatTest() {
        // Quand on execute le test sous windows startsWith -> retourne true
        // et le test est éxécuté et le test réussit comme le dossier c:/windows existe
        assumingThat(System.getenv("OS").startsWith("Windows"),
                () -> assertTrue(new File("C:\\Windows").exists(), "Répertoire Windows"));
    }
    
    // Test répété
    @DisplayName("Test répété")
  //  @RepeatedTest(value=4,name="{displayName} {currentRepetition}/{totalRepetitions}")
    @RepeatedTest(value=4,name=RepeatedTest.LONG_DISPLAY_NAME)
    public void repeteTest(RepetitionInfo info) {
        System.out.println(info.getCurrentRepetition() + " " +info.getTotalRepetitions());
        assertEquals("Hello World",Exemple.createString());
    }
    
    // Test paramétré
    
 // @ValueSource -> la source de donnée est un tableau
    @ParameterizedTest  
    @ValueSource(ints= {-4,-2,0,3,6})   
    public void paramTest(int param) {
        assertTrue(Exemple.interval(param, -4, 7));
    }
    
    // @EnumSource -> la source de donnée est une énumération
    @ParameterizedTest  
    @EnumSource(value=Month.class,mode=Mode.EXCLUDE,names={"FEBRUARY","APRIL","JUNE","SEPTEMBER","NOVEMBER"})
    public void enumParamTest(Month month) {
        assertEquals(LocalDate.of(2023, month, 31),Exemple.lastDayOfMonth(month));
    }
    
    // @CsvSource -> la source de données est un tableau de chaînes 
    // de caractères dans laquelle chaque arguments est séparés par une virgule
    @ParameterizedTest
    @CsvSource(delimiter = ';',value= {"1;3","4;5","41;1"})
    public void csvParamTest(int a,int b) {
        Calcul c=new Calcul();
        assertEquals(a+b, c.addition(a, b));
    }
    
    // @CsvSourceFile -> la source de données est d'un ou plusieurs fichiers CSV,
    // dans le fichier les valeurs sont séparé par ,
    @ParameterizedTest
    @CsvFileSource(delimiter = ';',resources = "/add_data_value.csv")
    public void csvFileParamTest(int a,int b) {
        Calcul c=new Calcul();
        assertEquals(a+b, c.addition(a, b));
    }
    
    // @MethodSource -> la source de données est fournit par une
    // méthode sous la forme d'un Stream la méthode ne doit pas avoir de paramètre
    @ParameterizedTest
    @MethodSource("providerData")
    public void paramMethodTest(int param) {
        assertTrue(Exemple.interval(param, -4, 7));
    }
    
    public static Stream<Integer> providerData(){
        return Stream.of(-4,-2,4,6);
    }
    
    // Test Dynamique
    @TestFactory
    Collection<DynamicTest> dynamicFactoryTest(){
        Calcul c=new Calcul();
        Collection<DynamicTest> dynTest=new ArrayList<>();
        for(int i=0;i<10;i++) {
            int j=i;
            dynTest.add(dynamicTest("Addition "+ i, () -> assertEquals(j+j,c.addition(j, j))));
        }
        return dynTest;
    }
    
    @DisplayName("Test d'injection de paramètre")
    @Test
    @Tag("InjectionParam")
    @Tag("Exemple")
    public void exempleInjectionTest(TestInfo info) {
        System.out.println(info.getDisplayName());
        System.out.println(info.getTestClass().get());
        System.out.println(info.getTestMethod().get());
        System.out.println(info.getTags());
        assertTrue(true);
    }
}
