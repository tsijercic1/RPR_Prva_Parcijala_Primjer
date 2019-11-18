package ba.unsa.etf.rpr;

public class RadnoMjesto {

    private String naziv;
    private double koeficijent;
    private Radnik radnik;

    public RadnoMjesto(String naziv, double koeficijent, Radnik radnik) {
        this.naziv = naziv;
        this.koeficijent = koeficijent;
        this.radnik = radnik;
    }

    public RadnoMjesto() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(double koeficijent) {
        this.koeficijent = koeficijent;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RadnoMjesto that = (RadnoMjesto) o;

        if (Double.compare(that.koeficijent, koeficijent) != 0) return false;
        return naziv != null ? naziv.equals(that.naziv) : that.naziv == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = naziv != null ? naziv.hashCode() : 0;
        temp = Double.doubleToLongBits(koeficijent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
