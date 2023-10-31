package GiocoDellOcaEliaGioele.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plancia {
    /**
     * Numero totale delle caselle
     */
    public static final int NUMERO_CASELLE = 63;

    /**
     * Lista delle caselle
     */
    private List<Casella> caselle;

    /**
     * Ritorna la lista delle caselle
     * 
     * @return
     */
    public List<Casella> getCaselle() {
        return caselle;
    }

    /**
     * Domande e risposte
     * 
     * Dichiarazione dell'array
     */
    private DomandaRisposta[] domandeRisposte;

    /**
     * Ritorna la lista delle domanda e risposte
     * 
     * @return
     */
    public DomandaRisposta[] getDomandeRisposte() {
        return domandeRisposte;
    }

    /**
     * Creazione della Plancia
     */
    public Plancia() {
        Random nDomanda = new Random();
        // Inizializzazione delle caselle
        inizializzaCaselle();

        // Inizializzazione dell'array delle domande e risposte
        DomandaRisposta[] domandeRisposte = new DomandaRisposta[] {
                new DomandaRisposta("Il lago Trasimeno si trova nel Lazio Vero o Falso??", false, 2),
                new DomandaRisposta("L'ape ha 4 ali. Vero o Falso??", true, 2),
                new DomandaRisposta(
                        "Il compito delle piastrine nel corpo umano, e' quello di combattere le infezioni Vero o Falso??",
                        false, 2),
                new DomandaRisposta("Gli occhi del camaleonte sono indipendenti l'uno dall'altro Vero o Falso??", true,
                        2),
                new DomandaRisposta("Nella torre di Pisa ci sono 33 campane Vero o Falso??", false, 2),
                new DomandaRisposta("L'ornitorinco depone le uova Vero o Falso??", true, 2),
                new DomandaRisposta("In una partita di bowling, il punteggio massimo e' 100 Vero o Falso??", false, 2),
                new DomandaRisposta(
                        "Il Canada e' il paese piu' grande del mondo per superficie terrestre Vero o Falso??",
                        true, 2),
                new DomandaRisposta("La Grande Muraglia Cinese e' visibile dalla Luna Vero o Falso??", false, 2),
                new DomandaRisposta(
                        "La Piramide di Giza e' l'ultima delle Sette Meraviglie del Mondo Antico ancora in piedi Vero o Falso??",
                        true, 2),
        };

        // vado a posizionare le caselle speciali
        int numeroCasuale = nDomanda.nextInt(10);
        caselle.set(3, new CasellaDomanda(4, 1, 4, '?', domandeRisposte[numeroCasuale]));
        numeroCasuale = 999;
        caselle.set(5, new CasellaBonusMalus(6, 1, 6, '+', 2));
        numeroCasuale = nDomanda.nextInt(10);
        caselle.set(9, new CasellaDomanda(10, 2, 9, '?', domandeRisposte[numeroCasuale]));
        numeroCasuale = 999;
        caselle.set(12, new CasellaBonusMalus(13, 5, 9, '+', 2));
        caselle.set(13, new CasellaImprevisto(14, 6, 9, '!'));
        caselle.set(19, new CasellaBonusMalus(20, 7, 4, '-', -2));
        numeroCasuale = nDomanda.nextInt(10);
        caselle.set(20, new CasellaDomanda(21, 7, 3, '?', domandeRisposte[numeroCasuale]));
        numeroCasuale = 999;
        caselle.set(24, new CasellaBonusMalus(25, 5, 1, '+', 2));
        caselle.set(27, new CasellaImprevisto(28, 2, 1, '!'));
        caselle.set(29, new CasellaBonusMalus(30, 2, 3, '-', -2));
        caselle.set(30, new CasellaSaltaTurno(31, 2, 4, 'X'));
        caselle.set(32, new CasellaBonusMalus(33, 2, 6, '-', -2));
        caselle.set(33, new CasellaImprevisto(34, 2, 7, '!'));
        caselle.set(34, new CasellaSaltaTurno(35, 2, 8, 'X'));
        caselle.set(39, new CasellaBonusMalus(40, 6, 7, '+', 2));
        numeroCasuale = nDomanda.nextInt(10);
        caselle.set(42, new CasellaDomanda(43, 6, 4, '?', domandeRisposte[numeroCasuale]));
        numeroCasuale = 999;
        caselle.set(46, new CasellaBonusMalus(47, 4, 2, '-', -2));
        caselle.set(47, new CasellaImprevisto(48, 3, 2, '!'));
        caselle.set(50, new CasellaSaltaTurno(51, 3, 5, 'X'));
        caselle.set(54, new CasellaBonusMalus(55, 5, 7, '+', 2));
        numeroCasuale = nDomanda.nextInt(10);
        caselle.set(55, new CasellaDomanda(56, 5, 6, '?', domandeRisposte[numeroCasuale]));
        numeroCasuale = 999;
        caselle.set(61, new CasellaBonusMalus(62, 4, 5, '-', -2));
    }

    /**
     * Inizializzazione delle caselle
     */
    private void inizializzaCaselle() {
        this.caselle = new ArrayList<>();
        int[][] coordinate = {
                { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 }, { 1, 8 },
                { 1, 9 }, { 2, 9 }, { 3, 9 }, { 4, 9 }, { 5, 9 }, { 6, 9 }, { 7, 9 }, { 7, 8 },
                { 7, 7 }, { 7, 6 }, { 7, 5 }, { 7, 4 }, { 7, 3 }, { 7, 2 }, { 7, 1 }, { 6, 1 },
                { 5, 1 }, { 4, 1 }, { 3, 1 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 },
                { 2, 6 }, { 2, 7 }, { 2, 8 }, { 3, 8 }, { 4, 8 }, { 5, 8 }, { 6, 8 }, { 6, 7 },
                { 6, 6 }, { 6, 5 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 5, 2 }, { 4, 2 }, { 3, 2 },
                { 3, 3 }, { 3, 4 }, { 3, 5 }, { 3, 6 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 5, 6 },
                { 5, 5 }, { 5, 4 }, { 5, 3 }, { 4, 3 }, { 4, 4 }, { 4, 5 }, { 4, 6 }
        };

        for (int i = 1; i <= NUMERO_CASELLE; i++) {
            int[] coord = coordinate[i - 1];
            this.caselle.add(new Casella(i, coord[0], coord[1], ' '));
        }
    }

    /**
     * Ritorna la casella dato il numero
     * 
     * @param numero Numero della casella
     * @return
     */
    public Casella getCasella(int numero) {
        return caselle.get(numero);
    }
}