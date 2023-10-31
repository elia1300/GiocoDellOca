package GiocoDellOcaEliaGioele.Class;

import java.util.Random;

import javax.swing.JOptionPane;

public class CasellaImprevisto extends CasellaSpeciale {
    /**
     * Creazione di una casella imprevisto
     * 
     * @param numero  Numero
     * @param riga    Riga
     * @param colonna Colonna
     * @param simbolo Simbolo
     */
    public CasellaImprevisto(int numero, int riga, int colonna, char simbolo) {
        super(numero, riga, colonna, simbolo);
    }

    /**
     * Applica l'effetto della casella imprevisto
     * 
     * @param giocatore Giocatore a cui applicare l'effetto
     */
    @Override
    public void applicaEffetto(Giocatore giocatore) {
        // Crazione pulsanti
        String[] opzioni = { "Pulsante 1", "Pulsante 2" };
        // Genera un numero casuale tra 0 e 1
        int sceltaCasuale = new Random().nextInt(2);

        JOptionPane.showOptionDialog(null, "Scegli uno dei pulsanti:", "Casella Imprevisto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opzioni, opzioni[sceltaCasuale]);

        if (sceltaCasuale == 0) {
            JOptionPane.showMessageDialog(null, "Ottima scelta!!! \navanza di 2 caselle");
            // Effetto casuale 1: bonus di 2 passi in avanti
            giocatore.muovi(2);
        } else if (sceltaCasuale == 1) {
            JOptionPane.showMessageDialog(null, "Che sfortuna \nretrocedi di 2 caselle");
            // Effetto casuale 2: malus di 2 passi indietro
            giocatore.muovi(-2);
        }
    }
}
