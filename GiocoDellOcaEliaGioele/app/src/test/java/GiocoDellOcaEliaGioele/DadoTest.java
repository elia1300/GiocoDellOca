package GiocoDellOcaEliaGioele;

import org.junit.jupiter.api.Test;

import GiocoDellOcaEliaGioele.Class.Dado;

import static org.junit.jupiter.api.Assertions.*;

public class DadoTest {

    @Test
    public void testLancioDado() {
        Dado dado = new Dado(6);

        int risultato = dado.lancio();

        assertTrue(risultato >= 1 && risultato <= 6, "Il risultato del lancio deve essere compreso tra 1 e 6");
    }
}
