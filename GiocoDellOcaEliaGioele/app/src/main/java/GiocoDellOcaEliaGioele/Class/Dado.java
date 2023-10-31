package GiocoDellOcaEliaGioele.Class;

import java.util.Random;

public class Dado {
    /**
     * Numero di facce del dado
     */
    private int numeroFacce;

    /**
     * Creazione del dado
     * 
     * @param numeroFacce Numero delle facce
     */
    public Dado(int numeroFacce) {
        this.numeroFacce = numeroFacce;
    }

    /**
     * Lancio del dado
     * 
     * @return
     */
    public int lancio() {
        return new Random().nextInt(numeroFacce - 1) + 1;
    }
}
