package ba.unsa.etf.rpr;

import java.util.Arrays;

public class Radnik {
    private String imePrezime, jmbg;
    private double[] plate = new double[1000];
    private int brDodanih = 0;

    public Radnik(String imePrezime, String jmbg) {
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
    }

    public double prosjecnaPlata() {
        double suma = 0;
        for(double plata : plate){
            suma+= plata;
        }

        return  brDodanih != 0 ? suma / brDodanih : 0;
    }

    public double prosjecnaPlataStream(){
        double suma = Arrays.stream(plate).reduce(0, (a, plata)->a+plata);
        return  brDodanih != 0 ? suma / brDodanih : 0;
    }

    public String getImePrezime() {
        return this.imePrezime;
    }

    public String getJmbg() {
        return this.jmbg;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void dodajPlatu(double plata) {
        if(brDodanih == 1000){
            throw new IllegalArgumentException("nesto " + imePrezime);
        }
        plate[brDodanih] = plata;
        brDodanih++;
    }
}
