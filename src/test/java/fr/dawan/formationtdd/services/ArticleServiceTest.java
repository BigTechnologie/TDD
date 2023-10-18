package fr.dawan.formationtdd.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.dawan.formationtdd.beans.Article;
import fr.dawan.formationtdd.repositories.ArticleRepository;

// Mockito

@ExtendWith(MockitoExtension.class) // Méthode 3
public class ArticleServiceTest {

    // @Mock // Méthode 2
    @Mock // Méthode 3 et 4
    private ArticleRepository repository;

    @InjectMocks // Méthode 4: injecter un mock
    private ArticleService service;

    // Spy
    private ArticleRepository realRepo;
    private ArticleRepository repoSpy;
    private ArticleService servSpy;

    // private AutoCloseable close; // Méthode 2

    // @BeforeEach
    // public void setup() {
    
    // Méthode 1: Créer le mock avec la méthode Mockito.mock()
    // repository=mock(ArticleRepository.class);
    // service=new ArticleService(repository);

    // Méthode 2: @Mock + MockitoAnnotations.openMocks()
    // close=MockitoAnnotations.openMocks(this);
    // service=new ArticleService(repository);

    // Méthode 3:  Avec l’extension Mockito pour JUnit 5
    // service=new ArticleService(repository);
    // }

    @BeforeEach
    public void setup() {
        realRepo = new ArticleRepository();
        repoSpy = spy(realRepo);
        servSpy = new ArticleService(repoSpy);
    }

//  @AfterEach // Méthode 2
//  public void tearDown() throws Exception {
//      close.close();
//  }
    
    @Test
    public void findByIdTest() throws Exception {
        Article a = new Article("Ecran 27 pouces", 290.0, LocalDate.of(2020, 10, 3));
        a.setId(5L);
        when(repository.findById(5L)).thenReturn(a);
        assertThat(service.findById(5L), Matchers.samePropertyValuesAs(a));
    }

    @Test
    public void findByIdExceptionTest() throws Exception {
        when(repository.findById(100L)).thenThrow(Exception.class);
        assertThrows(Exception.class,()-> service.findById(100L));
    }

    // Méthode static
    @Test
    public void checkTest() {
        try (MockedStatic<ArticleRepository> rs = Mockito.mockStatic(ArticleRepository.class)) {
            rs.when(() -> ArticleRepository.tool()).thenReturn(new Article());
            assertThat(ArticleService.check(), Matchers.samePropertyValuesAs(new Article()));
        }
    }

    // Méthode void -> doThrow, ....
    @Test
    public void deleteById() throws Exception {
        doThrow(Exception.class).when(repository).remove(100L);
        assertThrows(Exception.class, () -> service.delete(100L));
    }

    // ArgumentMatcher: préciser une plage de valeurs plus large pour les paramètres
    @Test
    public void findbyIdArgumentMatcherTest() throws Exception {
        Article a = new Article("Souris", 29.0, LocalDate.of(2020, 10, 3));
        when(repository.findById(anyLong())).thenReturn(a);
        assertThat(service.findById(15L), Matchers.samePropertyValuesAs(a));
        assertThat(service.findById(25L), Matchers.samePropertyValuesAs(a));
    }

    @Test
    public void findByDescriptionTest() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Souris", 29.0, LocalDate.of(2020, 10, 3)));
        articles.add(new Article("Souris Gamer sans fils", 89.0, LocalDate.of(2021, 10, 3)));
        articles.add(new Article("Souris Gamer fillaire", 59.0, LocalDate.of(2021, 11, 3)));
        when(repository.findByDescription(matches("^Souris.*$"))).thenReturn(articles);
        assertEquals(3, service.findByDescription("Souris").size());
    }

    // verify -> un mock se souvient de toutes les pérations qui ont été réalisé
    // On peut vérifier avec la méthode verify(T mock),  si ces opérations ont été utilisées
    @Test
    public void verifyTest() throws Exception {
        Article a = new Article("Souris", 29.0, LocalDate.of(2020, 10, 3));
        when(repository.findById(anyLong())).thenReturn(a);
        service.findById(1L);
        service.findById(2L);
        service.findById(1L);
        verify(repository).findById(2L);
        verify(repository, times(2)).findById(1L);
        verify(repository, never()).findAll();
    }

    @Test
    public void spyTest() throws Exception {
        Article a = new Article("Souris", 29.0, LocalDate.of(2020, 10, 3));
        a.setId(1L);
        doReturn(a).when(repoSpy).findById(1L);
        assertThat(servSpy.findById(1L), Matchers.sameInstance(a)); // MOCK
        assertEquals(4, servSpy.findAll().size()); // méthode réel de l'objet
    }

}
