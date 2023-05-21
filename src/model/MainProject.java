
package model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
import dao.CatalogoDAO;
import model.Utente;
import dao.UtenteDAO;




public class MainProject {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBackend3");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBackend3");
	    EntityManager em = emf.createEntityManager();
	    CatalogoDAO catalogoDAO = new CatalogoDAO(em);
	    UtenteDAO utenteDAO = new UtenteDAO();
	    
	    
	    Utente utente1 = new Utente();
        utente1.setNome("mario");
        utente1.setCognome("rossi");
        utente1.setDatanascita(LocalDate.of(1990, 5, 15));
        utenteDAO.aggiungiUtente(utente1);

        Utente utente2 = new Utente();
        utente2.setNome("marco");
        utente2.setCognome("viola");
        utente2.setDatanascita(LocalDate.of(1995, 6, 12));
        utenteDAO.aggiungiUtente(utente2);

        Utente utente3 = new Utente();
        utente3.setNome("giuseppe");
        utente3.setCognome("verd");
        utente3.setDatanascita(LocalDate.of(1999, 3, 10));
        utenteDAO.aggiungiUtente(utente3);
        
        Prestito prestito1 = new Prestito(utente1, a);


	    catalogoDAO.pulisciDatabase();

		Libri a = new Libri();
		a.setTitolo("ciao belli");
		a.setAnnopubblicazione(2020);
		a.setNumeropagine(300);
		a.setAutore("Sabri");
		a.setGenere("Horror");
		a.setISBN(1234);

		aggiungiCatalogo(a);

		Riviste aa = new Riviste();
		aa.setTitolo("MOTORSPORT");
		aa.setAnnopubblicazione(1996);
		aa.setNumeropagine(52);
		aa.setPeriodicita(Periodicita.SETTIMANALE);
		aa.setISBN(9012);

		aggiungiCatalogo2(aa);

		Libri b = new Libri();
		b.setTitolo("titolo del libro");
		b.setAnnopubblicazione(1996);
		b.setNumeropagine(300);
		b.setAutore("Harry Potter");
		b.setGenere("Fantasy");
		b.setISBN(5678);

		aggiungiCatalogo3(b);

		Riviste bb = new Riviste();
		bb.setTitolo("the pork");
		bb.setAnnopubblicazione(2018);
		bb.setNumeropagine(50);
		bb.setPeriodicita(Periodicita.SETTIMANALE);
		bb.setISBN(3456);

		aggiungiCatalogo4(bb);

		Libri c = new Libri();
		c.setTitolo("ciao belli2");
		c.setAnnopubblicazione(2020);
		c.setNumeropagine(300);
		c.setAutore("Sabri");
		c.setGenere("Horror");
		c.setISBN(2345);

		aggiungiCatalogo5(c);

		Riviste cc = new Riviste();
		cc.setTitolo("MOTORSPORT2");
		cc.setAnnopubblicazione(1996);
		cc.setNumeropagine(52);
		cc.setPeriodicita(Periodicita.SETTIMANALE);
		cc.setISBN(9988);

		aggiungiCatalogo6(cc);

		Libri d = new Libri();
		d.setTitolo("titolo del libro2");
		d.setAnnopubblicazione(1996);
		d.setNumeropagine(300);
		d.setAutore("Harry Potter");
		d.setGenere("Fantasy");
		d.setISBN(7766);

		aggiungiCatalogo7(d);

		Riviste dd = new Riviste();
		dd.setTitolo("the pork2");
		dd.setAnnopubblicazione(2018);
		dd.setNumeropagine(50);
		dd.setPeriodicita(Periodicita.SETTIMANALE);
		dd.setISBN(5544);

		aggiungiCatalogo8(dd);
		
		Riviste ee = new Riviste();
		ee.setTitolo("the pork3");
		ee.setAnnopubblicazione(2018);
		ee.setNumeropagine(50);
		ee.setPeriodicita(Periodicita.SETTIMANALE);
		ee.setISBN(6677);

		aggiungiCatalogo9(ee);	
		
		 Scanner scanner = new Scanner(System.in);
		    System.out.print("Inserisci il titolo da cercare: ");
		    String titolo = scanner.nextLine();

		    List<Catalogo> risultatiPerTitolo = catalogoDAO.cercaPerTitolo(titolo);
		    System.out.println("Risultati per titolo: " + risultatiPerTitolo);

		    int anno = 1996;
		    List<Catalogo> risultatiPerAnno = catalogoDAO.cercaPerAnno(anno);
		    System.out.println("Risultati per anno: " + risultatiPerAnno);

		    em.close();
		    emf.close();
		
	}
	 

	// AGGIUNTA DEL CATALOGO
	private static void aggiungiCatalogo(Libri a) {
	    em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo2(Riviste aa) {
	    em.getTransaction().begin();
	    em.persist(aa);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo3(Libri b) {
	    em.getTransaction().begin();
	    em.persist(b);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo4(Riviste bb) {
	    em.getTransaction().begin();
	    em.persist(bb);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo5(Libri c) {
	    em.getTransaction().begin();
	    em.persist(c);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo6(Riviste cc) {
	    em.getTransaction().begin();
	    em.persist(cc);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo7(Libri d) {
	    em.getTransaction().begin();
	    em.persist(d);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}

	private static void aggiungiCatalogo8(Riviste dd) {
	    em.getTransaction().begin();
	    em.persist(dd);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}
	
	private static void aggiungiCatalogo9(Riviste ee) {
	    em.getTransaction().begin();
	    em.persist(ee);
	    em.getTransaction().commit();
	    System.out.println("Elemento aggiunto nel Database");
	}


} 