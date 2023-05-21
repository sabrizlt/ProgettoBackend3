package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Catalogo", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "cercaPerAnno", query = "SELECT c FROM Catalogo c WHERE c.annopubblicazione = :anno")

public class Catalogo implements Serializable {
	@Id
	@Column(name = "ISBN")
	private Integer ISBN;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "annopublicazione")
	private Integer annopubblicazione;
	@Column(name = "numeroPagine")
	private int numeropagine;
	@Column(name = "periodicita")
	private Periodicita periodicita;

	public Catalogo() {
		super();
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnopubblicazione() {
		return annopubblicazione;
	}

	public void setAnnopubblicazione(Integer annopubblicazione) {
		this.annopubblicazione = annopubblicazione;
	}

	public int getNumeropagine() {
		return numeropagine;
	}

	public void setNumeropagine(int numeropagine) {
		this.numeropagine = numeropagine;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Catalogo [ISBN=" + ISBN + ", titolo=" + titolo + ", annopubblicazione=" + annopubblicazione
				+ ", numeropagine=" + numeropagine + ", periodicita=" + periodicita + "]";
	}

}