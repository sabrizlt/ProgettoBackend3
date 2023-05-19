package Esercizio;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table (name = "prestito")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Tipoprestito",discriminatorType = DiscriminatorType.STRING )

public class Prestito implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String utente;
	private int elementoprestato;
	private LocalDate inizioprestito;
	private LocalDate restituzioneprevista;
	private LocalDate restituzioneffettiva;
	
	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public int getElementoprestato() {
		return elementoprestato;
	}

	public void setElementoprestato(int elementoprestato) {
		this.elementoprestato = elementoprestato;
	}

	public LocalDate getInizioprestito() {
		return inizioprestito;
	}

	public void setInizioprestito(LocalDate inizioprestito) {
		this.inizioprestito = inizioprestito;
	}

	public LocalDate getRestituzioneprevista() {
		return restituzioneprevista;
	}

	public void setRestituzioneprevista(LocalDate restituzioneprevista) {
		this.restituzioneprevista = restituzioneprevista;
	}

	public LocalDate getRestituzioneffettiva() {
		return restituzioneffettiva;
	}

	public void setRestituzioneffettiva(LocalDate restituzioneffettiva) {
		this.restituzioneffettiva = restituzioneffettiva;
	}

	
	
	public Prestito() {
		super();
	}

	
	
	
}