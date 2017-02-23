
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

public class KlikkaustenKuuntelija_3nappia implements ActionListener {

    private JButton nappi;
    private JButton uudet;
    private JButton rek;
    private JCheckBox j1;
    private JCheckBox j2;
    private JCheckBox j3;
    ArrayList<Integer> melodiat = new ArrayList<>();
    private int montakoKertaaKutsuttu = 0;
    private ArrayList<String> tiedostonRivit = new ArrayList<>();

    public KlikkaustenKuuntelija_3nappia(JButton nappi, JButton uudet, JButton rek, JCheckBox j1, JCheckBox j2, JCheckBox j3) {
        this.nappi = nappi;
        this.j1 = j1;
        this.j2 = j2;
        this.j3 = j3;
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

        if (ae.getSource() == nappi) {
            if (j1.isSelected()) {
                melodiat.add(1);
            }
            if (j2.isSelected()) {
                melodiat.add(2);
            }
            if (j3.isSelected()) {
                melodiat.add(3);
            }
            LuoBiisit s = new LuoBiisit(melodiat);
            s.stringit();
            melodiat.clear();
            uudet.setEnabled(true);

        } else if (ae.getSource() == uudet) {             // U U D E T
            if (j1.isSelected()) {
                melodiat.add(1);
            }
            if (j2.isSelected()) {
                melodiat.add(2);
            }
            if (j3.isSelected()) {
                melodiat.add(3);
            }
            LuoBiisit s = new LuoBiisit(melodiat);
           
            if (montakoKertaaKutsuttu == tiedostonRivit.size()) {
                montakoKertaaKutsuttu = 0;
            }
        //    System.out.println("klik: montako = " + montakoKertaaKutsuttu);
            s.uudet(montakoKertaaKutsuttu, tiedostonRivit);
            montakoKertaaKutsuttu++;
            melodiat.clear();

        } else if (ae.getSource() == rek) {                    // R E K U R S O I
            LuoBiisit s = new LuoBiisit(melodiat);
            try {
                s.rekursoi();
            } catch (InterruptedException ex) {
                Logger.getLogger(KlikkaustenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
            melodiat.clear();
        }

    }

}
