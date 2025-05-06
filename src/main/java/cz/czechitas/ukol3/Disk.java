package cz.czechitas.ukol3;

import java.rmi.ServerError;
import java.util.Objects;

public class Disk {
    @Override
    public String toString() {
        return "Disk ma kapacitu " + kapacita + " bajtu a vyuzite misto " + vyuziteMisto + " bajtu.";
    }

    private long kapacita; //v bajtech
    private long vyuziteMisto; //v bajtech

    public long getVyuziteMisto() {

        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }

    public long getKapacita() {

        return kapacita;
    }

    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }
}
