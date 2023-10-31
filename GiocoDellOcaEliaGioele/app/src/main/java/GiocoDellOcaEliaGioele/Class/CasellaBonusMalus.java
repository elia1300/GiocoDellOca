package GiocoDellOcaEliaGioele.Class;

import javax.swing.JOptionPane;

public class CasellaBonusMalus extends CasellaSpeciale {

    /**
     * Numero di caselle da avanzare (positivo) o retrocedere (negativo)
     */
    private int avanzamento;

    /**
     * Creazione di una casella bonus/malus
     * 
     * @param numero      Numero
     * @param riga        Riga
     * @param colonna     Colonna
     * @param simbolo     Simbolo
     * @param avanzamento Bonus/malus
     */
    public CasellaBonusMalus(int numero, int riga, int colonna, char simbolo, int avanzamento) {
        super(numero, riga, colonna, simbolo);
        this.avanzamento = avanzamento;
    }

    @Override
    /**
     * Applica l'effetto a un giocatore.
     * L'avanzamento al giocatore (può essere positivo o negativo)
     */
    public void applicaEffetto(Giocatore giocatore) {
        JOptionPane.showMessageDialog(null, giocatore.getNome() + " si muove di " + avanzamento + " caselle!!!");
        giocatore.muovi(avanzamento);
    }
}
