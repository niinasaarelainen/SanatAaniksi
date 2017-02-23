
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class KlikkaustenKuuntelija implements ActionListener {

    private JButton soita;
    private JButton uudet;
    private JButton rek;
    private JCheckBox j1;
    private JCheckBox j2;
    private JCheckBox j3;
    private JCheckBox j4;
    ArrayList<Integer> mitkaMelodiatSoitetaan = new ArrayList<>();
    private int montakoKertaaKutsuttu = 0;
    private ArrayList<String> tiedostonRivit = new ArrayList<>();
    boolean rekursoinko;

    public KlikkaustenKuuntelija(JButton soita, JButton uudet, JButton rek, JCheckBox j1, JCheckBox j2, JCheckBox j3, JCheckBox j4) {
        this.soita = soita;
        this.j1 = j1;
        this.j2 = j2;
        this.j3 = j3;
        this.j4 = j4;
        this.uudet = uudet;
        this.rek = rek;

        File tiedosto = new File("src/tiedosto.txt");
        try (Scanner lukija = new Scanner(tiedosto)) {
            while (lukija.hasNextLine()) {
                tiedostonRivit.add(lukija.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KlikkaustenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
        //       System.out.println(tiedostonRivit.size());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (j1.isSelected()) {
            mitkaMelodiatSoitetaan.add(1);
        }
        if (j2.isSelected()) {
            mitkaMelodiatSoitetaan.add(2);
        }
        if (j3.isSelected()) {
            mitkaMelodiatSoitetaan.add(3);
        }
        if (j4.isSelected()) {
            mitkaMelodiatSoitetaan.add(4);
        }
        LuoBiisit s = new LuoBiisit(mitkaMelodiatSoitetaan);

        rekursoinko = false;
        if (ae.getSource() == soita) {                  // S O I T A
            if (montakoKertaaKutsuttu == tiedostonRivit.size()) {
                montakoKertaaKutsuttu = 0;
            }
            try {
                s.soita(montakoKertaaKutsuttu, tiedostonRivit, rekursoinko);
            } catch (InterruptedException ex) {
                Logger.getLogger(KlikkaustenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            mitkaMelodiatSoitetaan.clear();
            uudet.setEnabled(true);

        } else if (ae.getSource() == uudet) {             // U U D E T

            rekursoinko = false;
            if (montakoKertaaKutsuttu == tiedostonRivit.size()) {
                montakoKertaaKutsuttu = -1;
            }
            montakoKertaaKutsuttu++;
            try {
                s.soita(montakoKertaaKutsuttu, tiedostonRivit, rekursoinko);
            } catch (InterruptedException ex) {
                Logger.getLogger(KlikkaustenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            mitkaMelodiatSoitetaan.clear();

        } else if (ae.getSource() == rek) {                    // R E K U R S O I

            rekursoinko = true;
            try {
                s.soita(montakoKertaaKutsuttu, tiedostonRivit, rekursoinko);
            } catch (InterruptedException ex) {
                Logger.getLogger(KlikkaustenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            mitkaMelodiatSoitetaan.clear();
        }

    }

}
