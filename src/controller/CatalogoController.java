package controller;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Libri;

import model.Catalogo;

public class CatalogoController {
    public static void cercaPerTitolo(String titolo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Esercizio15b");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createNamedQuery("cercaPerTitolo");
        query.setParameter("Hanger", "%" + titolo + "%");
        List<Catalogo> risultati = query.getResultList();
        em.getTransaction().commit();

        if (!risultati.isEmpty()) {
            System.out.println("Risultati della ricerca:");
            for (Catalogo elemento : risultati) {
                System.out.println(elemento.toString());
            }
        } else {
            System.out.println("Nessun risultato trovato per il titolo specificato.");
        }

        em.close();
        emf.close();
    }

    public static void cercaPerAnno(int anno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Esercizio15b");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createNamedQuery("cercaPerAnno");
        query.setParameter("anno", anno);
        List<Catalogo> risultati = query.getResultList();
        em.getTransaction().commit();

        if (!risultati.isEmpty()) {
            System.out.println("Risultati della ricerca per anno di pubblicazione:");
            for (Catalogo elemento : risultati) {
                System.out.println(elemento.toString());
            }
        } else {
            System.out.println("Nessun risultato trovato per l'anno di pubblicazione specificato.");
        }

        em.close();
        emf.close();
    }
}
