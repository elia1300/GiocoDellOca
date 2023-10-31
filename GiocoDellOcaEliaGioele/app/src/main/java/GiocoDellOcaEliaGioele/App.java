package GiocoDellOcaEliaGioele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import GiocoDellOcaEliaGioele.Class.Casella;
import GiocoDellOcaEliaGioele.Class.CasellaImprevisto;
import GiocoDellOcaEliaGioele.Class.CasellaSpeciale;
import GiocoDellOcaEliaGioele.Class.Giocatore;
import GiocoDellOcaEliaGioele.Class.Plancia;
import GiocoDellOcaEliaGioele.Class.PlanciaPanel;

public class App extends JFrame {

    /**
     * Dimensione desiderata per ogni casella
     */
    public static final int CASELLA_DIMENSION = 89;
    /**
     * Velocità dell'animazione
     */
    public static final int ANIMATION_SPEED = 100;

    /**
     * Inizializzazione del pannello con la plancia
     */
    public PlanciaPanel planciaPanel = new PlanciaPanel();

    /**
     * Creazione dell'App
     */
    public App() {
        setTitle("Benvenuto al Gioco dell'Oca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Imposta la finestra in modalità schermo intero
        setLayout(new BorderLayout());

        // Aggiungi un'immagine di sfondo
        ImageIcon sfondoImage = new ImageIcon("app\\src\\main\\resources\\schermata_Iniziale.png");
        JLabel sfondoLabel = new JLabel(sfondoImage);

        add(sfondoLabel, BorderLayout.CENTER);

        // Aggiungi un pulsante per procedere alla scelta del numero di giocatori
        JButton procediButton = new JButton("Gioca");
        procediButton.setBorderPainted(false); // Rimuovi il bordo
        procediButton.setFocusPainted(false); // Rimuovi il bordo di focus
        procediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chiudi la schermata iniziale e apri la schermata di scelta del numero di
                // giocatori
                mostraSchermataSceltaGiocatori(); // Chiamata alla funzione per mostrare la schermata successiva
                dispose(); // Chiudi la schermata iniziale
            }
        });

        // Personalizza il pulsante, ad esempio, impostando il colore del testo o dello
        // sfondo
        procediButton.setForeground(Color.WHITE);
        procediButton.setBackground(Color.BLUE);
        procediButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 24));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 128, 0));
        buttonPanel.add(procediButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Posiziona la finestra al centro dello schermo
        setVisible(true);
    }

    /*
     * Mostra la schermata per inizializzare il gioco
     */
    void mostraSchermataSceltaGiocatori() {
        JFrame frame = new JFrame("Gioco dell'Oca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Imposta le dimensioni del frame e rimuove la barra del titolo della finestra

        // Menu iniziale per scegliere il numero di giocatori
        String[] opzioniNumeroGiocatori = { "2", "3", "4", "5" };
        String sceltaNumeroGiocatori = (String) JOptionPane.showInputDialog(
                frame,
                "Seleziona il numero di giocatori:",
                "Selezione Giocatori",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opzioniNumeroGiocatori,
                opzioniNumeroGiocatori[0]);

        int numeroGiocatori = Integer.parseInt(sceltaNumeroGiocatori);

        if (numeroGiocatori <= 0) {
            return; // Se il numero di giocatori è minore o uguale a 0, non apriamo la schermata del
                    // gioco
        }

        // Array di colori da associare ai giocatori
        Color[] coloriGiocatori = { Color.RED, Color.PINK, Color.ORANGE, Color.GREEN, Color.BLUE };

        for (int i = 0; i < numeroGiocatori; i++) {
            String nomeGiocatore;
            do {
                nomeGiocatore = JOptionPane.showInputDialog("Inserisci il nome del giocatore " + (i + 1));
            } while (!controllaNomeGiocatore(nomeGiocatore));

            if (nomeGiocatore == null) {
                return; // Se l'utente annulla la scelta dei nomi dei giocatori, interrompiamo il gioco
            }
            Giocatore giocatore = new Giocatore(nomeGiocatore);
            giocatore.setColore(coloriGiocatori[i]); // Assegna un colore al giocatore
            this.planciaPanel.aggiungiGiocatore(giocatore);
        }

        final int[] giocatoreCorrente = { 0 };

        JButton buttonLanciaDadi = new JButton("Lancia i Dadi");
        JLabel labelTurno = new JLabel("Turno del giocatore: " + planciaPanel.getGiocatori().get(giocatoreCorrente[0]).getNome());
        labelTurno.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
        // Aggiungi un pannello per l'animazione del dado
        JPanel animazioneDadoPanel = new JPanel();
        animazioneDadoPanel.setLayout(new BorderLayout());

        // Aggiungi un'etichetta per visualizzare il risultato del dado
        JLabel risultatoDadoLabel = new JLabel("Risultato del dado: ");
        animazioneDadoPanel.add(risultatoDadoLabel, BorderLayout.CENTER);

        // Aggiungi il pannello dell'animazione del dado alla parte inferiore destra
        frame.add(animazioneDadoPanel, BorderLayout.SOUTH);

        buttonLanciaDadi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Giocatore giocatore = planciaPanel.getGiocatori().get(giocatoreCorrente[0]);
                

                // Controlla se il giocatore deve saltare il turno
                if (giocatore.getDeveSaltareTurno()) {
                    giocatoreCorrente[0] = (giocatoreCorrente[0] + 1) % planciaPanel.getGiocatori().size();
                    
                    // Passa immediatamente al prossimo giocatore senza l'animazione
                    if (giocatoreCorrente[0] < planciaPanel.getGiocatori().size()) {
                        buttonLanciaDadi.doClick(); // Simula il click del pulsante per il prossimo giocatore
                    }
                    giocatore.terminaTurno();
                    return; // Termina la funzione per evitare di avviare l'animazione
                }

                int lancio = planciaPanel.getDado().lancio();
                risultatoDadoLabel.setText("Risultato del dado: " + lancio);
                // Avvia l'animazione per muovere il giocatore solo se non deve saltare il turno
                planciaPanel.startAnimation(lancio);

                Timer timer = new Timer(ANIMATION_SPEED, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Controlla se l'animazione è completa
                        if (!planciaPanel.isAnimating()) {
                            // Ferma il timer dell'animazione
                            ((Timer) e.getSource()).stop();

                            // Muovi effettivamente il giocatore dopo l'animazione
                            giocatore.muovi(lancio);
                            planciaPanel.repaint();

                            if (giocatore.getPosizione() >= Plancia.NUMERO_CASELLE - 1) {
                                JOptionPane.showMessageDialog(frame,
                                        "Complimenti " + giocatore.getNome() + " ha vinto la partita!");
                                // frame.dispose();
                                boolean rigioca = mostraPopupConfermaRigioca();
                                if (rigioca) {
                                    // Resetta lo stato del gioco
                                    new App();
                                } else {
                                    // Chiudi il gioco
                                    frame.dispose();
                                    return;
                                }
                            }

                            // Controlla se il giocatore è atterrato su una casella speciale
                            Casella casellaAttuale = planciaPanel.getPlancia().getCasella(giocatore.getPosizione());
                            if (casellaAttuale instanceof CasellaSpeciale) {
                                CasellaSpeciale casellaSpeciale = (CasellaSpeciale) casellaAttuale;

                                if (casellaSpeciale instanceof CasellaImprevisto) {
                                    // Gestisci effetto CasellaImprevisto
                                    CasellaImprevisto casellaImprevisto = (CasellaImprevisto) casellaSpeciale;
                                    casellaImprevisto.applicaEffetto(giocatore);
                                } else {
                                    // Gestisci altri tipi di caselle speciali
                                    gestisciEffettoCasellaSpeciale(giocatore, casellaSpeciale);
                                }
                                planciaPanel.repaint();
                            }

                            // Passa al prossimo giocatore (o al primo giocatore se tutti hanno giocato il
                            // loro turno)
                            giocatoreCorrente[0] = (giocatoreCorrente[0] + 1) % planciaPanel.getGiocatori().size();
                            labelTurno.setText("Turno del giocatore: " + planciaPanel.getGiocatori().get(giocatoreCorrente[0]).getNome());
                        }
                    }
                });
                // Avvia il timer dell'animazione
                timer.start();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(planciaPanel, BorderLayout.CENTER);
        panel.add(buttonLanciaDadi, BorderLayout.SOUTH);
        panel.add(labelTurno, BorderLayout.EAST);

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Controllo per vedere se 2 giocatori hanno lo stesso nome *
     * 
     * @param nome Nome del giocatore
     * @return True se il nome è valido
     */
    boolean controllaNomeGiocatore(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Il nome del giocatore non puo' essere vuoto.", "Errore",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        for (Giocatore giocatore : this.planciaPanel.getGiocatori()) {
            if (giocatore.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(null, "I nomi dei giocatori devono essere diversi.", "Errore",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    /**
     * Controllo per vedere se 2 giocatori hanno lo stesso nome
     * 
     * @param g Classe Giocatore
     * @return True se il nome è valido
     */
    boolean controllaNomeGiocatore(Giocatore g) {
        return this.controllaNomeGiocatore(g.getNome());
    }

    /**
     * Applica l'effetto di una casella speciale ad un giocatore
     * 
     * @param giocatore
     * @param casellaSpeciale
     */
    void gestisciEffettoCasellaSpeciale(Giocatore giocatore, CasellaSpeciale casellaSpeciale) {
        casellaSpeciale.applicaEffetto(giocatore);
    }

    public boolean mostraPopupConfermaRigioca() {
        int scelta = JOptionPane.showConfirmDialog(
                this, "Vuoi rigiocare?", "Vittoria!", JOptionPane.YES_NO_OPTION);

        return scelta == JOptionPane.YES_OPTION;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
