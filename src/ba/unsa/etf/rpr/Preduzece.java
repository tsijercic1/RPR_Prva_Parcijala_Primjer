package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Preduzece {
    private int osnovica;
    private List<RadnoMjesto> radnaMjesta = new ArrayList<>();


    public Preduzece(int osnovica) throws NeispravnaOsnovica {
        postaviOsnovicu(osnovica);
    }

    public int dajOsnovicu() {
        return this.osnovica;
    }

    public void postaviOsnovicu(int osnovica) throws NeispravnaOsnovica {
        if(osnovica <= 0){
            throw new NeispravnaOsnovica("Neispravna osnovica " + osnovica);
        }
        this.osnovica = osnovica;
    }

    public void novoRadnoMjesto(RadnoMjesto radnoMjesto) {
        radnaMjesta.add(radnoMjesto);
    }

    public Map<RadnoMjesto, Integer> sistematizacija() {

        return null;
    }

    public void zaposli(Radnik radnik, String naziv) {
        List<RadnoMjesto> filtrirani = radnaMjesta.stream()
                .filter(radnoMjesto -> radnoMjesto.getNaziv().equals(naziv) && radnoMjesto.getRadnik()==null).collect(Collectors.toList());

        if(filtrirani.isEmpty()){
            throw new IllegalStateException("Nijedno radno mjesto tog tipa nije slobodno");
        }

        filtrirani.get(0).setRadnik(radnik);
    }

    public Set<Radnik> radnici() {
        return null;
    }

    public double iznosPlate() {
//        iznos koliko bi ukupno trebalo novca da se isplate plate svim radnicima
        double suma = 0;
        for (RadnoMjesto radnoMjesto:radnaMjesta) {
            if(radnoMjesto.getRadnik()!=null){
                suma+=radnoMjesto.getKoeficijent()*osnovica;
            }
        }
        return suma;
    }

    public void obracunajPlatu() {

        radnaMjesta.stream().filter(radnoMjesto -> radnoMjesto.getRadnik() != null)
                .forEach(radnoMjesto -> {
                    radnoMjesto.getRadnik().dodajPlatu(osnovica * radnoMjesto.getKoeficijent());
                });
    }

    public List<Radnik> filterRadnici(Function<Radnik,Boolean> function) {
        return null;
    }

    public List<Radnik> vecaProsjecnaPlata(double prosjecnaPlata) {
        return null;
    }
}
