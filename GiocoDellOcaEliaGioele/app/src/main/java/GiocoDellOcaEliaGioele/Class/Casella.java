package GiocoDellOcaEliaGioele.Class;

public class Casella {
    private int numero;
    private int riga;
    private int colonna;
    private char simbolo;

    /**
     * Creazione di una casella
     * 
     * @param numero  Numero della casella
     * @param riga    Riga della casella
     * @param colonna Colonna della casella
     * @param simbolo Simbolo della casella
     */
    public Casella(int numero, int riga, int colonna, char simbolo) {
        this.numero = numero;
        this.riga = riga;
        this.colonna = colonna;
        this.simbolo = simbolo;
    }

    /**
     * Ritorna il numero
     * 
     * @return
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * Ritorna la riga
     * 
     * @return
     */
    public int getRiga() {
        return this.riga;
    }

    /**
     * Ritorna la colonna
     * 
     * @return
     */
    public int getColonna() {
        return this.colonna;
    }

    /**
     * Ritorna il simbolo
     * 
     * @return
     */
    public char getSimbolo() {
        return this.simbolo;
    }
}
