package GiocoDellOcaEliaGioele.Class;

public class DomandaRisposta {
    /**
     * Domanda
     */
    private String domanda;
    /**
     * Risposta corretta
     */
    private boolean rispostaCorretta;
    /**
     * Effetto
     */
    private int effetto;

    /**
     * Creazione di una domanda
     * 
     * @param domanda          Domanda
     * @param rispostaCorretta Risposta corretta
     * @param effetto          Effetto
     */
    public DomandaRisposta(String domanda, boolean rispostaCorretta, int effetto) {
        this.domanda = domanda;
        this.rispostaCorretta = rispostaCorretta;
        this.effetto = effetto;
    }

    /**
     * Ritorna la domanda
     * 
     * @return
     */
    public String getDomanda() {
        return domanda;
    }

    /**
     * Controlla se la risposta data è quella corretta
     * 
     * @return
     */
    public boolean isRispostaCorretta() {
        return rispostaCorretta;
    }

    /**
     * Ritorna l'effetto
     * 
     * @return
     */
    public int getEffetto() {
        return effetto;
    }
}
