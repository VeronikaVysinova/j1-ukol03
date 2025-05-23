package cz.czechitas.ukol3;

import java.util.Objects;

public class Pocitac {
    @Override
    public String toString() {
        return "Pocitac {" + "cpu/" + cpu + "; ram/" + ram + "; pevnyDisk=" + pevnyDisk + "}";
    }

    private boolean jeZapnuty = false;
    private Procesor cpu; // centralni proces. jednotka
    private Pamet ram;
    private Disk pevnyDisk;






    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }



    public boolean jeZapnuty() {  // bez get a set
        return jeZapnuty;
    }

    public void zapniSe() {
        if (jeZapnuty()) {
            System.err.println("Pocitac je jiz zapnuty.");

        } else if (pevnyDisk == null || ram == null || cpu == null) {
            System.out.println("Pocitac nema vse potrebne pro zapnuti.");

        } else {
            jeZapnuty = true;
            System.out.println("Pocitac se zapnul.");

        }
    }

    public void vypniSe() {
        if (!jeZapnuty){
            jeZapnuty = true;
            System.out.println("Pocitac se vypnul.");

        }


    }

    public void vytvorSouborOVelikosti (long velikost) {  //velikost = velikost noveho souboru v bajtech
        long vyuzite = getPevnyDisk().getVyuziteMisto(); //ziskam hodnotu jiz vyuziteho mista
        long maxKapacita = getPevnyDisk().getKapacita(); //ziskam hodnotu kapacity celeho disku

        while (jeZapnuty) {
            if ((vyuzite + velikost) > maxKapacita) {
                System.err.println("Soubor se nevejde na disk. Vyuzite misto je: " + vyuzite + " bajtu.");
            } else {
                vyuzite = vyuzite + velikost; //zvetsi mi hodnotu vyuziteho mista o novy soubor
                pevnyDisk.setVyuziteMisto(vyuzite); //ulozi novou hodnotu vyuziteho mista
                System.out.println("Nova velikost vyuziteho mista je: " + vyuzite + " bajtu.");
            }
            return;
        }

    }

    public void vymazSouborOVelikosti (long velikost) {

        long vyuzite = getPevnyDisk().getVyuziteMisto(); //ziskam hodnotu jiz vyuziteho mista

        while (jeZapnuty) {
            if ((vyuzite - velikost) < 0) {
                System.err.println("Velikost vyuziteho mista nesmi klesnout pod 0 bajtu.");

            } else {
                vyuzite = vyuzite - velikost;
                pevnyDisk.setVyuziteMisto(vyuzite);
                System.out.println("Velikost vyuziteho mista po smazani souboru je: " + vyuzite + " bajtu.");
            }
            return;


        }

    }

}