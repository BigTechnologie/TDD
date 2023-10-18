package fr.dawan.formationtdd.services;

import java.util.List;

import fr.dawan.formationtdd.beans.Article;
import fr.dawan.formationtdd.repositories.ArticleRepository;

public class ArticleService {

    private ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public void save(Article a) {
        repository.saveOrUpdate(a);
    }

    public void delete(Article a) {
        repository.remove(a);
    }

    public void delete(long id) throws Exception {
        repository.remove(id);
    }

    public Article findById(long id) throws Exception {
        return repository.findById(id);
    }

    public List<Article> findAll() {
        return repository.findAll();
    }

    public List<Article> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    public static Article check() {
        return ArticleRepository.tool();
    }
}
