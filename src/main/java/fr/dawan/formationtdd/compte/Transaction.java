package fr.dawan.formationtdd.compte;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

    private double montant;

    private LocalDate date;

    public Transaction(double montant, LocalDate date) {
        this.montant = montant;
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, montant);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        return Objects.equals(date, other.date)
                && Double.doubleToLongBits(montant) == Double.doubleToLongBits(other.montant);
    }

    @Override
    public String toString() {
        return "Transaction [montant=" + montant + ", date=" + date + "]";
    }
}
