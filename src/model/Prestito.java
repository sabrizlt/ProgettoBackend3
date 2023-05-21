package model;

import java.time.LocalDate;

public class Prestito {
    private Utente utente;
    private Catalogo elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, Catalogo elementoPrestato) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = LocalDate.now();
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
    }

    public Utente getUtente() {
        return utente;
    }

    public Catalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
