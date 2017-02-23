
import java.util.ArrayList;
import java.util.Scanner;
import tktl.Soitin;

public class Soittaja extends Thread {

    private Soitin soitin = new Soitin();
    private ArrayList<Aani> aanet;

    public Soittaja(ArrayList<Aani> aanet) {
        this.aanet = aanet;
    }
    
    public Soittaja(){
        
    }

    @Override
    public void run() {
        soitin.soita(aanet);
    }

    
}
