package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Catalogo;

import java.util.List;

public class CatalogoDAO {

    private EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void aggiungiCatalogo(Catalogo catalogo) {
        em.getTransaction().begin();
        em.persist(catalogo);
        em.getTransaction().commit();
        System.out.println("Elemento aggiunto nel Database");
    }

    public void pulisciDatabase() {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Catalogo");
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Database pulito");
    }

    public List<Catalogo> cercaPerTitolo(String titolo) {
        Query query = em.createQuery("SELECT c FROM Catalogo c WHERE c.titolo = :titolo");
        query.setParameter("titolo", titolo);
        return query.getResultList();
    }

    public List<Catalogo> cercaPerAnno(int anno) {
        Query query = em.createQuery("SELECT c FROM Catalogo c WHERE c.annopubblicazione = :anno");
        query.setParameter("anno", anno);
        return query.getResultList();
    }
}
