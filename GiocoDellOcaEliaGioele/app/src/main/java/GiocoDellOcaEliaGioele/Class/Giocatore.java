package GiocoDellOcaEliaGioele.Class;

import java.awt.Color;

public class Giocatore {
    /**
     * Nome
     */
    private String nome;

    /**
     * Ritorna il nome
     * 
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Posizione corrente
     */
    private int posizione;

    /**
     * Ritorna la posizione
     * 
     * @return
     */
    public int getPosizione() {
        return posizione;
    }

    /**
     * Imposta la posizione del giocatore
     * 
     * @param posizione
     */
    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    /**
     * Colore del giocatore
     */
    private Color colore;

    /**
     * Ritorna il colore del giocatore
     * 
     * @return
     */
    public Color getColore() {
        return colore;
    }

    /**
     * Imosta il colore del giocatore
     * 
     * @param colore
     */
    public void setColore(Color colore) {
        this.colore = colore;
    }

    /**
     * Variabile per indicare se il giocatore deve saltare il turno
     */
    private boolean deveSaltareTurno;

    /**
     * Ritorna se il giocatore deve saltare il prossimo turno
     * 
     * @return
     */
    public boolean getDeveSaltareTurno() {
        return deveSaltareTurno;
    }

    /**
     * Fai saltare il turno al giocatore
     */
    public void setDeveSaltareTurno() {
        deveSaltareTurno = true;
    }

    /**
     * Creazione di un giocatore
     * 
     * @param nome Nome
     */
    public Giocatore(String nome) {
        this.nome = nome;
        // Inizializzo le variabili
        this.posizione = 0;
        this.colore = Color.BLACK;
        this.deveSaltareTurno = false;
    }

    /**
     * Termina il turno del giocatore
     */
    public void terminaTurno() {
        deveSaltareTurno = false;
    }

    /**
     * Muovi il giocatore
     * 
     * @param passi Numero di passi di cui muovere il giocatore
     */
    public void muovi(int passi) {
        posizione += passi;
    }
}
