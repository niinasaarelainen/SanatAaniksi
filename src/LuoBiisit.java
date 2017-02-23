
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LuoBiisit extends Thread {

    private ArrayList<Integer> mitkaMelodiatSoitetaan = new ArrayList<>();
    private ArrayList<Aani> aanet1 = new ArrayList<>();
    private ArrayList<Aani> aanet2 = new ArrayList<>();
    private ArrayList<Aani> aanet3 = new ArrayList<>();
    private ArrayList<Aani> aanet4 = new ArrayList<>();

    private int rekLkm = 0;
    private String rivi1;
    private String rivi2;
    private String rivi3;
    private final String rivi4_rock = "MM AA GG FF G G   ";

    
    public LuoBiisit(ArrayList<Integer> mitkaMelodiatSoitetaan) {
        this.mitkaMelodiatSoitetaan = mitkaMelodiatSoitetaan;

    }

    
    public void soita(int monesko, ArrayList<String> tiedostonRivit, boolean rekursoinko) throws InterruptedException {

        System.out.println(mitkaMelodiatSoitetaan);

        rivi1 = tiedostonRivit.get(monesko);
        //      System.out.println(rivi1);
        //      System.out.println(monesko);
        if (monesko + 1 == tiedostonRivit.size()) {
            monesko = 0;
        }
        rivi2 = tiedostonRivit.get(monesko + 1);
//        System.out.println(rivi2);
//        System.out.println(monesko + 1);
        if (monesko + 2 == tiedostonRivit.size()) {
            monesko = 0;
        }
        rivi3 = tiedostonRivit.get(monesko + 2);
//        System.out.println(rivi3);
//        System.out.println(monesko + 2);

        mitkaMelodiatSoitetaan();

        if (rekursoinko) {
            Thread.sleep(2900);
            rekLkm++;
            if (rekLkm < 5) {
                try {
                    soita(monesko, tiedostonRivit, rekursoinko);
                } catch (InterruptedException ex) {
                    Logger.getLogger(KlikkaustenKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void mitkaMelodiatSoitetaan() {
        String toUpperCase = rivi1.toUpperCase();
        String toUpperCase2 = rivi2.toUpperCase();
        String toUpperCase3 = rivi3.toUpperCase();

        if (mitkaMelodiatSoitetaan.contains(1)) {
            jonoAaniksi(toUpperCase, aanet1);
        }
        if (mitkaMelodiatSoitetaan.contains(2)) {
            jonoAaniksi(toUpperCase2, aanet2);
        }
        if (mitkaMelodiatSoitetaan.contains(3)) {
            jonoAaniksi(toUpperCase3, aanet3);
        }
        if (mitkaMelodiatSoitetaan.contains(4)) {
            jonoAaniksi(rivi4_rock, aanet4);
        }
        LuoSoittajat();
    }

    
    public void LuoSoittajat() {
        Soittaja eero = new Soittaja(aanet1);
        Soittaja venla = new Soittaja(aanet2);
        Soittaja makke = new Soittaja(aanet3);
        Soittaja queen = new Soittaja(aanet4);
        eero.start();
        venla.start();
        makke.start();
        queen.start();
    }

    
    public static ArrayList<Aani> jonoAaniksi(String jono, ArrayList<Aani> aanet) {
        System.out.println(jono);

        for (int i = 0; i < jono.length(); i++) {
            if (jono.charAt(i) == 'Ö') {
                Aani aani = new Aani(80, 0.111);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'Ä') {
                Aani aani = new Aani(90, 0.111);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'C') {
                Aani aani = new Aani(261.626, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'V') {
                Aani aani = new Aani(293.665, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'D') {
                Aani aani = new Aani(293.665, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'J') {
                Aani aani = new Aani(311.13, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'E') {
                Aani aani = new Aani(329.628, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'F') {
                Aani aani = new Aani(349.228, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'T') {
                Aani aani = new Aani(369.99, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'G') {
                Aani aani = new Aani(391.995, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'N') {
                Aani aani = new Aani(415.3, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'A') {
                Aani aani = new Aani(440.000, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'M') {
                Aani aani = new Aani(466.16, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == 'H') {
                Aani aani = new Aani(493.883, 0.3);
                aanet.add(aani);
            } else if (jono.charAt(i) == ' ') {
                Aani aani = new Aani(0, 0.1);
                aanet.add(aani);
            }

        }
        System.out.println(aanet);
        return aanet;
    }

}
