package GiocoDellOcaEliaGioele.Class;

import javax.swing.JOptionPane;

public class CasellaDomanda extends CasellaSpeciale {
    /**
     * Classe DomandaRisposta
     */
    private DomandaRisposta domandaRisposta;

    /**
     * Creazione di una casella con una domanda
     * 
     * @param numero          Numero
     * @param riga            Riga
     * @param colonna         Colonna
     * @param simbolo         Simbolo
     * @param domandaRisposta Classe DomandaRisposta
     */
    public CasellaDomanda(int numero, int riga, int colonna, char simbolo, DomandaRisposta domandaRisposta) {
        super(numero, riga, colonna, simbolo);
        this.domandaRisposta = domandaRisposta;
    }

    @Override
    /**
     * Aplica l'effetto di una casella ad un giocatore
     */
    public void applicaEffetto(Giocatore giocatore) {
        // Risposta alla domanda
        boolean rispostaGiocatore = chiediDomanda(giocatore);

        // Controlla che la risposta del giocatore corrisponda alla risposta giusta
        // della domanda
        if (rispostaGiocatore == domandaRisposta.isRispostaCorretta()) {
            JOptionPane.showMessageDialog(null,
                    giocatore.getNome() + ", la risposta e' corretta!!! \navanzi di " + domandaRisposta.getEffetto()
                            + " caselle.");
            giocatore.muovi(domandaRisposta.getEffetto());
        } else {
            JOptionPane.showMessageDialog(null,
                    giocatore.getNome() + ", la risposta e' sbagliata!!! \ntorni indietro di "
                            + domandaRisposta.getEffetto() + " caselle.");
            giocatore.muovi(-domandaRisposta.getEffetto());
        }
    }

    /**
     * Chiedi la domanda al giocatore
     * 
     * @param giocatore Giocatore a cui chiedere la domanda
     * @return Risposta alla domanda
     */
    private boolean chiediDomanda(Giocatore giocatore) {
        String rispostaStringa = JOptionPane.showInputDialog(
                "Domanda: " + domandaRisposta.getDomanda() + "\nRispondi con Vero (true) o Falso (false):");
        return Boolean.parseBoolean(rispostaStringa);
    }
}
