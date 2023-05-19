package Esercizio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.catalog.Catalog;
import java.util.Scanner;

public class MainProject {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Esercizio15b");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {

		pulisciDatabase();

		Libri a = new Libri();
		a.setTitolo("ciao belli");
		a.setAnnopubblicazione(2020);
		a.setNumeropagine(300);
		a.setAutore("Sabri");
		a.setGenere("Horror");
		a.setISBN(1234);

		aggiungiCatalogo(a);

		Libri b = new Libri();
		b.setTitolo("titolo del libro");
		b.setAnnopubblicazione(1996);
		b.setNumeropagine(300);
		b.setAutore("Harry Potter");
		b.setGenere("Fantasy");
		b.setISBN(5678);

		aggiungiCatalogo2(b);

		Riviste aa = new Riviste();
		aa.setTitolo("MOTORSPORT");
		aa.setAnnopubblicazione(1996);
		aa.setNumeropagine(52);
		aa.setPeriodicita(Periodicita.SETTIMANALE);
		aa.setISBN(9012);

		aggiungiCatalogo3(aa);

		Riviste bb = new Riviste();
		bb.setTitolo("the fork");
		bb.setAnnopubblicazione(2018);
		bb.setNumeropagine(50);
		bb.setPeriodicita(Periodicita.SETTIMANALE);
		bb.setISBN(3456);

		aggiungiCatalogo4(bb);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserisci il titolo da cercare: ");
		String titolo = scanner.nextLine();

		cercaPerTitolo(titolo);


		
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("Inserisci il codice ISBN da cercare: ");
		String ISBN = scanner2.nextLine();

		cercaPerISBN(ISBN);

		scanner2.close();


	}

	private static void cercaPerTitolo(String titolo) {
		em.getTransaction().begin();
		Query query = em.createNamedQuery("cercaPerTitolo");
		query.setParameter("Hanger", "%" + titolo + "%");
		List<Libri> risultati = query.getResultList();
		em.getTransaction().commit();

		if (!risultati.isEmpty()) {
			System.out.println("Risultati della ricerca:");
			for (Libri libro : risultati) {
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("Nessun risultato trovato per il titolo specificato.");
		}
	}
	
	private static void cercaPerISBN(String ISBN) {
	    em.getTransaction().begin();
	    Query query = em.createNamedQuery("cercaPerISBN");
	    query.setParameter("ISBN", ISBN);
	    List<Libri> risultati = query.getResultList();
	    em.getTransaction().commit();

	    if (!risultati.isEmpty()) {
	        System.out.println("Risultati della ricerca per ISBN:");
	        for (Libri libro : risultati) {
	            System.out.println(libro.toString());
	        }
	    } else {
	        System.out.println("Nessun risultato trovato per l'ISBN specificato.");
	    }
	}


	private static void pulisciDatabase() {
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Catalogo");
		query.executeUpdate();
		em.getTransaction().commit();
		System.out.println("Database pulito");
	}

	private static boolean elementoEsiste(String titolo) {
		Query query = em.createNamedQuery("cercaPerTitolo");
		query.setParameter("Hanger", titolo);
		List<Catalogo> risultati = query.getResultList();
		return !risultati.isEmpty();
	}

	private static void aggiungiCatalogo(Libri a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo2(Libri b) {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo3(Riviste aa) {
		em.getTransaction().begin();
		em.persist(aa);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo4(Riviste bb) {
		em.getTransaction().begin();
		em.persist(bb);
		em.getTransaction().commit();
		System.out.println("Elemento aggiunto nel Database");

	}

}
