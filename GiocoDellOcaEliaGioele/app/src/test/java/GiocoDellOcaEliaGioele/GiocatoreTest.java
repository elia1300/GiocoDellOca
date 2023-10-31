package GiocoDellOcaEliaGioele;

import org.junit.jupiter.api.Test;

import GiocoDellOcaEliaGioele.Class.Giocatore;

import static org.junit.jupiter.api.Assertions.*;

public class GiocatoreTest {

    @Test
    public void testMuovi() {
        Giocatore giocatore = new Giocatore("Alice");
        assertEquals(0, giocatore.getPosizione()); // Il giocatore dovrebbe iniziare dalla posizione 1

        giocatore.muovi(3); // Il giocatore muove 3 caselle in avanti
        assertEquals(3, giocatore.getPosizione()); // La posizione dovrebbe essere 4

        giocatore.muovi(-2); // Il giocatore muove 2 caselle indietro
        assertEquals(1, giocatore.getPosizione()); // La posizione dovrebbe essere 2
    }

    @Test
    public void testNomeGiocatore() {
        Giocatore giocatore = new Giocatore("Bob");
        assertEquals("Bob", giocatore.getNome()); // Verifica il nome del giocatore
    }

}
