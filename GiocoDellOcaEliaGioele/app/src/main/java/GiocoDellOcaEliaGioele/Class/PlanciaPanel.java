package GiocoDellOcaEliaGioele.Class;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import GiocoDellOcaEliaGioele.App;

public class PlanciaPanel extends JPanel {
    private List<Giocatore> giocatori;

    public List<Giocatore> getGiocatori() {
        return giocatori;
    }

    /**
     * Variabile Plancia
     */
    private Plancia plancia;

    public Plancia getPlancia() {
        return plancia;
    }

    /**
     * Dado
     */
    private Dado dado = new Dado(6);

    public Dado getDado() {
        return dado;
    }

    /**
     * Timer per l'animazione
     */
    private Timer animationTimer;
    private boolean isAnimating = false;

    /**
     * Ritorna se si sta eseguendo un animazione
     * 
     * @return
     */
    public boolean isAnimating() {
        return isAnimating;
    }

    private JButton chiudiButton;
    private JButton schermataInizialeButton;

    public PlanciaPanel() {
        // Inizializzazione Plancia
        this.plancia = new Plancia();
        // Inizializzazione lista giocatori
        giocatori = new ArrayList<>();

        // Crea e avvia il timer per l'animazione
        animationTimer = new Timer(App.ANIMATION_SPEED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimation(); // Aggiorna l'animazione
                repaint(); // Ridisegna la plancia
            }
        });
        animationTimer.setRepeats(true);
        chiudiButton = new JButton("Chiudi il Gioco");
        chiudiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int conferma = JOptionPane.showConfirmDialog(
                        null, "Sei sicuro di voler chiudere il gioco?", "Conferma chiusura", JOptionPane.YES_NO_OPTION);

                if (conferma == JOptionPane.YES_OPTION) {
                    // Chiudi il gioco solo se l'utente conferma
                    System.exit(0); // Chiude l'applicazione
                }
            }
        });

        chiudiButton.setBackground(Color.RED);
        chiudiButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
        // Crea il pulsante per tornare alla schermata iniziale
        schermataInizialeButton = new JButton("Torna alla Schermata Iniziale");
        schermataInizialeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int conferma = JOptionPane.showConfirmDialog(
                        null, "Sei sicuro di voler tornare al menu' iniziale?", "Conferma chiusura",
                        JOptionPane.YES_NO_OPTION);
                if (conferma == JOptionPane.YES_OPTION) {
                    new App();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PlanciaPanel.this);
                    frame.dispose(); // Chiude la schermata attuale
                }
            }
        });
        schermataInizialeButton.setBackground(Color.BLUE);
        schermataInizialeButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
        // Aggiungi i pulsanti al pannello
        add(schermataInizialeButton);
        add(chiudiButton);
        setLayout(new FlowLayout());

    }

    /**
     * Aggiungi un giocatore
     * 
     * @param giocatore
     */
    public void aggiungiGiocatore(Giocatore giocatore) {
        giocatori.add(giocatore);
    }

    /**
     * Lancia un dado
     */
    public void lanciaDadoEMuovi() {
        if (!isAnimating) {
            // Simula il lancio del dado (da 1 a 6)
            // Ogni punto del dado corrisponde alla dimensione della casella
            startAnimation(dado.lancio() * App.CASELLA_DIMENSION);
        }
    }

    /**
     * Esegue l'animazione dei passi
     * 
     * @param passi
     */
    public void startAnimation(int passi) {
        isAnimating = true;

        int velocitaAnimazione = App.ANIMATION_SPEED; // Velocità dell'animazione
        int numeroPassiTotali = passi * velocitaAnimazione / 1000; // Numero totale di passi

        Timer timer = new Timer(velocitaAnimazione, new ActionListener() {
            int passiRimanenti = numeroPassiTotali;
            int giocatoreIndex = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Controlla se l'animazione è completa
                if (passiRimanenti <= 0) {
                    // Ferma il timer quando l'animazione è completa
                    ((Timer) e.getSource()).stop();
                    isAnimating = false;
                    return;
                }

                Giocatore giocatore = giocatori.get(giocatoreIndex);
                int posizione = giocatore.getPosizione() - 1;

                // Calcola la posizione successiva del giocatore
                int posizioneSuccessiva = (posizione + 1) % plancia.getCaselle().size();
                giocatore.setPosizione(posizioneSuccessiva + 1);

                passiRimanenti--;
                repaint();

                giocatoreIndex = (giocatoreIndex + 1) % giocatori.size();
            }
        });

        // Avvia il timer dell'animazione
        timer.start();
    }

    private void updateAnimation() {
        // Non è necessario aggiornare l'animazione in questo modo
    }

    /**
     * Costruisci la plancia
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int numCaselle = plancia.getCaselle().size();
        int larghezzaCasella = App.CASELLA_DIMENSION; // Larghezza della casella
        int altezzaCasella = App.CASELLA_DIMENSION; // Altezza della casella

        int fontSize = Math.min(larghezzaCasella, altezzaCasella) / 5; // Rimpicciolisci il font
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g.setFont(font);
        Color[] gradientColors = new Color[Plancia.NUMERO_CASELLE];

        int numSteps = gradientColors.length;

        // Definisci i colori di inizio e fine per la sfumatura
        Color startColor = Color.ORANGE;
        Color middleColor = Color.GREEN;
        Color endColor = Color.BLUE;

        for (int i = 0; i < numSteps; i++) {
            float fraction = (float) i / (numSteps - 1);
            Color currentColor;

            if (fraction < 0.5f) {
                currentColor = new Color(
                        (int) (startColor.getRed() + (middleColor.getRed() - startColor.getRed()) * fraction / 0.5f),
                        (int) (startColor.getGreen()
                                + (middleColor.getGreen() - startColor.getGreen()) * fraction / 0.5f),
                        (int) (startColor.getBlue()
                                + (middleColor.getBlue() - startColor.getBlue()) * fraction / 0.5f));
            } else {
                float adjustedFraction = (fraction - 0.5f) / 0.5f;
                currentColor = new Color(
                        (int) (middleColor.getRed() + (endColor.getRed() - middleColor.getRed()) * adjustedFraction),
                        (int) (middleColor.getGreen()
                                + (endColor.getGreen() - middleColor.getGreen()) * adjustedFraction),
                        (int) (middleColor.getBlue()
                                + (endColor.getBlue() - middleColor.getBlue()) * adjustedFraction));
            }

            gradientColors[i] = currentColor;
        }

        for (int i = 0; i < numCaselle; i++) {
            Casella casella = plancia.getCasella(i);

            int x = casella.getColonna() * larghezzaCasella;
            int y = casella.getRiga() * altezzaCasella;
            int coloreIndex = i % gradientColors.length;
            g.setColor(gradientColors[coloreIndex]);
            g.fillRect(x, y, larghezzaCasella, altezzaCasella);

            g.setColor(Color.BLACK);
            g.drawRect(x, y, larghezzaCasella, altezzaCasella);

            int xNumero = x + larghezzaCasella / 2 - fontSize / 2;
            int yNumero = y + altezzaCasella / 2 + fontSize / 2;

            if (casella.getNumero() == 63) { // Aggiungi "ARRIVO" alla casella numero 63
                g.drawString("Arrivo", xNumero, yNumero);
            } else if (casella.getNumero() == 1) {
                g.drawString("Via", xNumero, yNumero);
            } else {
                // Disegna il numero e il simbolo su due righe separate
                g.drawString(String.valueOf(casella.getNumero()), xNumero, yNumero);
                g.drawString(String.valueOf(casella.getSimbolo()), xNumero + 5, yNumero + 20);
            }
        }

        for (Giocatore giocatore : giocatori) {
            int posizione = giocatore.getPosizione();
            int xGiocatore = plancia.getCasella(posizione).getColonna() * larghezzaCasella + larghezzaCasella / 2;
            int yGiocatore = plancia.getCasella(posizione).getRiga() * altezzaCasella + altezzaCasella / 2;

            int diametroPallino = larghezzaCasella / 3; // Rimpicciolisci il pallino dei giocatori

            // Imposta il colore del giocatore
            g.setColor(giocatore.getColore());

            // Disegna il pallino sopra l'immagine di sfondo
            g.fillOval(xGiocatore - diametroPallino, yGiocatore - diametroPallino, diametroPallino * 2,
                    diametroPallino * 2);
        }
    }
}
