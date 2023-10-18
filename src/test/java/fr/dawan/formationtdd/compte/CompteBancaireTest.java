package fr.dawan.formationtdd.compte;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CompteBancaireTest {

    @Mock
    private Transactions transactions;

    @InjectMocks
    private CompteBancaire compteBancaire;

    private PrintStream output = System.out;
    private ByteArrayOutputStream outputTest = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputTest));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(output);
    }

    @Test
    public void depotNegatifTest() {
        assertThrows(Exception.class, () -> compteBancaire.depot(-100.0));
    }

    @Test
    public void depotTest() throws Exception {
        compteBancaire.depot(100);
        verify(transactions).ajout(new Transaction(100, LocalDate.now()));
    }

    @Test
    public void retraitNegatifTest() {
        assertThrows(Exception.class, () -> compteBancaire.retrait(-100.0));
    }

    @Test
    public void retraitTest() throws Exception {
        compteBancaire.retrait(100);
        verify(transactions).ajout(new Transaction(-100, LocalDate.now()));
    }

    @Test
    public void imprimerReleveTest() throws Exception {
        List<Transaction> lst = new ArrayList<>();
        lst.add(new Transaction(100, LocalDate.of(2023, 07, 28)));
        lst.add(new Transaction(-200, LocalDate.of(2023, 06, 21)));
        when(transactions.getAll()).thenReturn(lst);
        compteBancaire.imprimerReleve();
        assertEquals("|\t100,00\t2023-07-28\t100,00\t|" + System.lineSeparator() + "|\t-200,00\t2023-06-21\t-100,00\t|",
                outputTest.toString().trim());
    }

}
