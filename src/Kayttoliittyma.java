
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Ikkuna");
        frame.setPreferredSize(new Dimension(401, 301));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("\nMitkä melodiat haluat kuulla yhtaikaa?\n"));

        JCheckBox j1 = new JCheckBox("Melodia 1");
        JCheckBox j2 = new JCheckBox("Melodia 2");
        JCheckBox j3 = new JCheckBox("Melodia 3");
        JCheckBox j4  = new JCheckBox("We Will We Will Rock You !");

        container.add(j1);
        container.add(j2);
        container.add(j3);
        container.add(j4);

        JButton soita = new JButton("Soita sama uudestaan!");

        JButton uudet = new JButton("Uudet melodiat ");
        uudet.setEnabled(false);

        JButton rek = new JButton("REKURSOI");

        KlikkaustenKuuntelija kopioija = new KlikkaustenKuuntelija(soita, uudet, rek, j1, j2, j3, j4);
        soita.addActionListener(kopioija);
        uudet.addActionListener(kopioija);
        rek.addActionListener(kopioija);
        j1.addActionListener(kopioija);
        j2.addActionListener(kopioija);
        j3.addActionListener(kopioija);
        j4.addActionListener(kopioija);

        container.add(soita, BorderLayout.SOUTH);
        container.add(uudet, BorderLayout.SOUTH);
        container.add(rek, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
