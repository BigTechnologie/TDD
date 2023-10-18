package fr.dawan.formationtdd;

public class FizzBuzz {

    // Test => pour un nombre non divisible par 3 et par 5
    // la méthode convert va retourner le nombre convertie en chaine de caractère
    // 3: On écrit le code nécéssaire pour que le test réussisse
    // 4: On refactorise le code jusqu'à ce que la qualité du code est jugé
    // satisfaissante
    // 5: On écrit le prochain test
    // public String convert(int i) {
    // return Integer.toString(i);
    // }

    // Test => pour un nombre divisible 3 la méthode convert retourne "Fizz"
    // Tous les tests doivent être valide pour vérifier qu'il n'y a pas de
    // régression
    // public String convert(int i) {
    // if (i % 3 == 0) {
    // return "Fizz";
    // }
    // return Integer.toString(i);
    // }

    // Test => pour un nombre divisible 5, la méthode convert retourne "Buzz"
    // public String convert(int i) {
    // if (i % 3 == 0) {
    // return "Fizz";
    // } else if (i % 5 == 0) {
    // return "Buzz";
    // }
    // return Integer.toString(i);
    // }

    // Test => pour un nombre divisible 3 et par 5, la méthode convert retourne
    // "FizzBuzz"
    // public String convert(int i) {
    // if (i % 3 == 0 && i % 5 == 0) {
    // return "FizzBuzz";
    // } else if (i % 3 == 0) {
    // return "Fizz";
    // } else if (i % 5 == 0) {
    // return "Buzz";
    // }
    // return Integer.toString(i);
    // }

    // Résultat 2ème partie de l'exercice
    public String convert(int i) {
        if (i == 0) {
            return "0";
        }
        String num = Integer.toString(i);
        if (i % 15 == 0 || (num.contains("3") && num.contains("5"))) {
            return "FizzBuzz";
        }
        if (i % 3 == 0 || num.contains("3")) {
            return "Fizz";
        }
        if (i % 5 == 0 || num.contains("5")) {
            return "Buzz";
        }
        return num;
    }

}
