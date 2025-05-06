package cz.czechitas.ukol3;

import java.util.Objects;

public class Procesor {

    private String vyrobce;
    private long rychlost; // v Hz

    @Override
    public String toString() {
        return "Informace o procesoru: " + "vyrobce = " + vyrobce + ", rychlost = " + rychlost + " Hz.";
    }

    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long rychlost) {
        this.rychlost = rychlost;
    }

    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        Objects.requireNonNull(vyrobce);
        if (vyrobce.isBlank()){
            System.err.println("Vyrobce nemuze byt prazdny.");
        }
        this.vyrobce = vyrobce;
    }


}