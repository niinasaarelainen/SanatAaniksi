
public class Aani {

    private double taajuus;
    private double kesto;

    public Aani(double taajuus, double kesto) {
        this.taajuus = taajuus;
        this.kesto = kesto;
    }

    public double getTaajuus() {
        return this.taajuus;
    }

    public double getKesto() {
        return this.kesto;
    }

    @Override
    public String toString() {
        return "" + this.taajuus + "Hz (" + this.kesto + "s" + ")";
    }

}
