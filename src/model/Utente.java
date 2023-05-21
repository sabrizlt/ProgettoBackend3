package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table (name = "utente")
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)

public class Utente implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "numerotessera")
private int numerotessera;
@Column(name = "nome")
private String nome;
@Column(name = "cognome")
private String cognome;
@Column(name = "datanascita")
private LocalDate datanascita;


public int getNumerotessera() {
	return numerotessera;
}


public void setNumerotessera(int numerotessera) {
	this.numerotessera = numerotessera;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getCognome() {
	return cognome;
}


public void setCognome(String cognome) {
	this.cognome = cognome;
}


public LocalDate getDatanascita() {
	return datanascita;
}


public void setDatanascita(LocalDate localDate) {
	this.datanascita = localDate;
}


public Utente() {
	super();
}









}