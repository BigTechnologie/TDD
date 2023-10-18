package fr.dawan.formationtdd.repositories;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.dawan.formationtdd.beans.Article;

public class ArticleRepository {

    private static Map<Long, Article> data = new HashMap<>();

    private long nextId = 5L;

    static {
        Article p = new Article("Cable HDMI", 19.0, LocalDate.of(2020, 10, 10));
        p.setId(1L);
        data.put(1L, p);
        p = new Article("Cable RJ45", 15.0, LocalDate.of(2010, 10, 10));
        p.setId(2L);
        data.put(2L, p);
        p = new Article("Souris", 49.0, LocalDate.of(2019, 1, 10));
        p.setId(3L);
        data.put(3L, p);
        p = new Article("Ecran LCD ", 190.0, LocalDate.of(2020, 07, 10));
        p.setId(4L);
        data.put(4L, p);
    }

    public Article saveOrUpdate(Article a) {
        if (a.getId() == 0) {
            a.setId(nextId);
            data.put(nextId, a);
            return data.get(nextId++);
        } else {
            data.put(a.getId(), a);
            return data.get(a.getId());
        }

    }

    public void remove(long id) throws Exception {
        if (!data.containsKey(id)) {
            throw new Exception();
        }
        data.remove(id);
    }

    public void remove(Article a) {
        data.remove(a.getId());
    }

    public Article findById(long id) throws Exception {
        Article a = data.get(id);
        if (a == null) {
            throw new Exception();
        }
        return a;
    }

    public List<Article> findByDescription(String description) {
        return data.values().stream().filter(a -> a.getDescription().contains(description))
                .collect(Collectors.toList());
    }

    public List<Article> findAll() {
        return data.values().stream().toList();
    }

    public static Article tool() {
        return new Article();
    }
}
