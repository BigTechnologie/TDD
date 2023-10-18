package fr.dawan.formationtdd;

import fr.dawan.formationtdd.compte.CompteBancaire;

public class App 
{
    public static void main( String[] args )
    {
        
        // FizzBuzz
        FizzBuzz f=new FizzBuzz();
        for(int i=1;i<=100;i++) {
            System.out.println(f.convert(i));
        }
        
        
        // Compte Bancaire
        CompteBancaire cb=new CompteBancaire();
        try {
            cb.retrait(200.0);
            cb.depot(400.0);
            cb.depot(50.5);
            cb.retrait(20.0);
            cb.imprimerReleve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
