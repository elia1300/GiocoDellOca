package GiocoDellOcaEliaGioele;


import org.junit.jupiter.api.Test;

import GiocoDellOcaEliaGioele.Class.CasellaSpeciale;
import GiocoDellOcaEliaGioele.Class.Giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasellaSpecialeTest {
    @Test
    public void testCreazioneCasellaSpeciale() {
        CasellaSpeciale casellaSpeciale = new CasellaSpeciale(2, 0, 1, 'B') {
            @Override
            public void applicaEffetto(Giocatore giocatore) {
                // Implementa l'effetto desiderato per il test
            }
        };

        assertEquals(2, casellaSpeciale.getNumero(), "Il numero della casella deve essere 2");
        assertEquals(0, casellaSpeciale.getRiga(), "La riga della casella deve essere 0");
        assertEquals(1, casellaSpeciale.getColonna(), "La colonna della casella deve essere 1");
        assertEquals('B', casellaSpeciale.getSimbolo(), "Il simbolo della casella deve essere 'B'");
    }

    @Test
    public void testApplicaEffettoCasellaSpeciale() {
        Giocatore giocatore = new Giocatore("Giocatore 1");
        CasellaSpeciale casellaSpeciale = new CasellaSpeciale(2, 0, 1, '+') {
            @Override
            public void applicaEffetto(Giocatore giocatore) {
                // Implementa l'effetto desiderato per il test
                giocatore.muovi(2); // Ad esempio, muovi il giocatore di 2 caselle
            }
        };

        // Esegui l'effetto sulla casella speciale
        casellaSpeciale.applicaEffetto(giocatore);

        assertEquals(2, giocatore.getPosizione(), "Il giocatore dovrebbe trovarsi alla casella 3 dopo l'applicazione dell'effetto.");
    }
}
