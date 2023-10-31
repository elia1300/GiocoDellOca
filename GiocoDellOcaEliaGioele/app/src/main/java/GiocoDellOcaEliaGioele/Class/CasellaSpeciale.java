package GiocoDellOcaEliaGioele.Class;

public abstract class CasellaSpeciale extends Casella {
    /**
     * Creazione di una casella speciale
     * 
     * @param numero  Numero
     * @param riga    Riga
     * @param colonna Colonna
     * @param simbolo Simbolo
     */
    public CasellaSpeciale(int numero, int riga, int colonna, char simbolo) {
        super(numero, riga, colonna, simbolo);
    }

    /**
     * Applicazione dell'effetto ad un giocatore
     * 
     * @param giocatore Giocatore a cui applicare l'effetto
     */
    public abstract void applicaEffetto(Giocatore giocatore);
}
