package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Utente;

import java.util.List;

public class UtenteDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBackend3");
    private static EntityManager em = emf.createEntityManager();

    public void aggiungiUtente(Utente utente) {
        em.getTransaction().begin();
        em.persist(utente);
        em.getTransaction().commit();
        System.out.println("Utente aggiunto nel Database");
    }

    public List<Utente> getUtenti() {
        Query query = em.createQuery("SELECT u FROM Utente u");
        return query.getResultList();
    }

    public void pulisciDatabaseUtenti() {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Utente");
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Database utenti pulito");
    }
}
