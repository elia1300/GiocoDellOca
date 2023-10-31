package GiocoDellOcaEliaGioele;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import GiocoDellOcaEliaGioele.Class.Giocatore;

public class AppTest {

    @Test
    public void testControllaNomeGiocatore() {
        // Inizializzo la classe App
        App app = new App();

        // Creo il primo giocatore
        Giocatore g1 = new Giocatore("Test Giocatore");
        boolean result1 = app.controllaNomeGiocatore(g1);
        assertTrue(result1);
        // Aggiungo il giocatore alla lista di giocatori
        app.planciaPanel.aggiungiGiocatore(g1);

        // Creo il secondo giocatore
        Giocatore g2 = new Giocatore("Test Giocatore");
        boolean result2 = app.controllaNomeGiocatore(g2);
        assertFalse(result2);
        app.planciaPanel.aggiungiGiocatore(g2);
    }
}
