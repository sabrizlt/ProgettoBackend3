package Esercizio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Riviste extends Catalogo implements Serializable {

	@Enumerated
	@Column(name = "periodicita")
	private Periodicita periodicita;

	public Riviste() {
		super();
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Riviste [periodicita=" + periodicita + "]";
	}

}