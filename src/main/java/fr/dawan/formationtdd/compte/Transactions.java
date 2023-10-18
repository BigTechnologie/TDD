package fr.dawan.formationtdd.compte;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    
    private List<Transaction> lstTransaction=new ArrayList<>();

    public void ajout(Transaction tra) {
        lstTransaction.add(tra);
    }

    public List<Transaction> getAll() {
        return lstTransaction;
    }

}
