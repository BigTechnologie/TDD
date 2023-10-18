package fr.dawan.formationtdd;

public class Calcul {

    public int addition(int a, int b) {
        return a + b;
    }

    public double division(double d1, double d2) {
        if (d2 == 0.0) {
            throw new ArithmeticException("Division par 0");
        }
        return d1 / d2;
    }
}
