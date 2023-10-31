package GiocoDellOcaEliaGioele;

import org.junit.jupiter.api.Test;

import GiocoDellOcaEliaGioele.Class.Casella;
import GiocoDellOcaEliaGioele.Class.Plancia;

import static org.junit.jupiter.api.Assertions.*;

public class PlanciaTest {

    @Test
    public void testCreazionePlancia() {
        Plancia plancia = new Plancia();
        Casella casella = plancia.getCasella(0);

        assertEquals(Plancia.NUMERO_CASELLE, plancia.getCaselle().size(), "Il numero di caselle deve essere corretto");
        assertEquals(1, casella.getNumero(), "La prima casella deve avere numero 1");
    }
}
