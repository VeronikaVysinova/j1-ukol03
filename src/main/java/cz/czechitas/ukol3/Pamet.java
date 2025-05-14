package cz.czechitas.ukol3;

import java.util.Objects;

public class Pamet {
    @Override
    public String toString() { //vypise informace do radku
        return "Kapacita pameti = " + kapacita + " bajtu.";
    }


    private long kapacita; // v bajtech

    private long getKapacita() {

        return kapacita;
    }

    public void setKapacita(long kapacita) {

        this.kapacita = kapacita;
    }

}
