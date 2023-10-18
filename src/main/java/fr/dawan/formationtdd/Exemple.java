package fr.dawan.formationtdd;

import java.awt.Dimension;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.dawan.formationtdd.beans.Personne;

public class Exemple {

    public static double[] processArray() {
        double t[] = { 4.5, 6.7, 1.2, 3.4, 100.000000001 };
        return t;
    }

    public static List<Integer> processIterable() {
        return Arrays.asList(1, 6, 3, 7);
    }

    public static void processTime() throws InterruptedException {
        Thread.sleep(200);
    }

    public static boolean interval(int valTest, int valMin, int Valmax) {
        return valTest >= valMin && valTest <= Valmax;
    }

    public static Dimension createDimension() {
        return new Dimension(600, 400);
    }

    public static Personne createPersonne() {
        Personne p = new Personne("John", "Doe", LocalDate.of(1989, 6, 10));
        p.setId(3L);
        return p;
    }

    public static String createString() {
        return "Hello World";
    }

    public static List<Integer> createList() {
        return Arrays.asList(1, 6, 4, 23);
    }

    public static Map<Integer, String> createMap() {
        Map<Integer, String> m = new HashMap<>();
        m.put(12, "Hello");
        m.put(45, "World");
        m.put(42, "Reponse");
        return m;
    }

    public static String createJson() {
        Personne p = new Personne("Alan", "Smithe", LocalDate.of(1991, 3, 14));
        p.setId(1L);

        // Serialisation en json avec jackson
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Ajouter le support de java.time.*
        String json = "";
        try {
            json = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String createArrayJson() {
        List<Personne> lstPer = new ArrayList<>();
        Personne p = new Personne("John", "Doe", LocalDate.of(1991, 3, 10));
        p.setId(1L);
        lstPer.add(p);
        p = new Personne("Jane", "Doe", LocalDate.of(1996, 3, 10));
        p.setId(2L);
        lstPer.add(p);

        // Serialisation en json avec jackson
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Ajouter le support de java.time.*
        String json = "";
        try {
            json = mapper.writeValueAsString(lstPer);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static LocalDate lastDayOfMonth(Month month) {
        switch (month) {
        case JANUARY:
        case MARCH:
        case MAY:
        case JULY:
        case AUGUST:
        case OCTOBER:
        case DECEMBER:
            return LocalDate.of(2023, month, 31);
        case FEBRUARY:
            return LocalDate.of(2023, month, 28);
        default:
            return LocalDate.of(2023, month, 30);
        }
    }

}
