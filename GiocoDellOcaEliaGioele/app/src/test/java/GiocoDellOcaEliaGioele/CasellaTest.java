
package GiocoDellOcaEliaGioele;
import org.junit.jupiter.api.Test;

import GiocoDellOcaEliaGioele.Class.Casella;

import static org.junit.jupiter.api.Assertions.*;

public class CasellaTest {

    @Test
    public void testCreazioneCasella() {
        Casella casella = new Casella(1, 0, 0, 'A');

        assertEquals(1, casella.getNumero(), "Il numero della casella deve essere 1");
        assertEquals(0, casella.getRiga(), "La riga della casella deve essere 0");
        assertEquals(0, casella.getColonna(), "La colonna della casella deve essere 0");
        assertEquals('A', casella.getSimbolo(), "Il simbolo della casella deve essere 'A'");
    }
}
