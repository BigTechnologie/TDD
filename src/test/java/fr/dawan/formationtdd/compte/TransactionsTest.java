package fr.dawan.formationtdd.compte;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionsTest {

    private Transactions transactions;

    @BeforeEach
    public void setup() {
        transactions = new Transactions();
    }

    @Test
    public void getAllTransactionTest() {
        assertEquals(0, transactions.getAll().size());
    }

    @Test
    public void ajoutTransactionTest() {
        Transaction tra = new Transaction(100.0, LocalDate.of(2023, 7, 27));
        transactions.ajout(tra);
        assertEquals(transactions.getAll().size(), 1);
        assertThat(transactions.getAll().get(0), Matchers.samePropertyValuesAs(tra));
    }
}
