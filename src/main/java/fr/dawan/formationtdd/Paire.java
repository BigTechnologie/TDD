package fr.dawan.formationtdd;

public class Paire {

    public String parite(int... values) {
        int somme = 0;
        for (int v : values) {
            somme += v;
        }
        return (somme & 0x1) == 0 ? "pair" : "impair";
    }
}
