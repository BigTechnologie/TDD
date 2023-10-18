package fr.dawan.formationtdd.compte;

import java.time.LocalDate;
import java.util.List;

public class CompteBancaire {
    
    private Transactions transactions;
    
    public CompteBancaire() {
        transactions=new Transactions();
    }

    public void depot(double montant) throws Exception {
        if(montant<0.0) {
            throw new Exception();
        } 
        transactions.ajout(new Transaction(montant,LocalDate.now()));
    }

    public void retrait(double montant) throws Exception {
        if(montant<0.0) {
            throw new Exception();
        }
        transactions.ajout(new Transaction(-montant,LocalDate.now()));
    }

    public void imprimerReleve() {
        List<Transaction> lst=transactions.getAll();
        double somme=0.0;
        for(Transaction t : lst) {
            somme+=t.getMontant();
            System.out.println(String.format("|\t%.2f\t%s\t%.2f\t|", t.getMontant(),t.getDate(),somme));
        }
    }
    

}
