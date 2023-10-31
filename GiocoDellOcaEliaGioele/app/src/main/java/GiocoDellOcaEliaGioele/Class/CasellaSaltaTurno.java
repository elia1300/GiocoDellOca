package GiocoDellOcaEliaGioele.Class;

import javax.swing.JOptionPane;

public class CasellaSaltaTurno extends CasellaSpeciale {

    /**
     * Creazione di una casella salta turno
     * 
     * @param numero  Numero
     * @param riga    Riga
     * @param colonna Colonna
     * @param simbolo Simbolo
     */
    public CasellaSaltaTurno(int numero, int riga, int colonna, char simbolo) {
        super(numero, riga, colonna, simbolo);
    }

    /**
     * Applica l'effetto della casella
     * 
     * @param giocatore Giocatore a cui applicare l'effetto
     */
    @Override
    public void applicaEffetto(Giocatore giocatore) {
        JOptionPane.showMessageDialog(null, giocatore.getNome() + " saltera' il prossimo turno.");
        giocatore.setDeveSaltareTurno();
    }
}
