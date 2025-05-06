package cz.czechitas.ukol3;

import java.util.Objects;

public class Pocitac {
    @Override
    public String toString() {
        return "Pocitac{" + "cpu=" + cpu + ", ram=" + ram + ", pevnyDisk=" + pevnyDisk + '}';
    }

    private boolean jeZapnuty = false; // nastaveni ze na zacatku je pc vypnuty
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
            System.out.println("Pocitac je jiz zapnuty.");

        } else if (pevnyDisk == null || ram == null || cpu == null) {
            System.out.println("Pocitac nema vse potrebne pro zapnuti.");

        } else {
            jeZapnuty = true;
            System.out.println("Pocitac se zapnul.");

        }
    }

    public void vypniSe() {
        if (!jeZapnuty){

        }else{
            jeZapnuty = false;
            System.out.println("Pocitac se vypnul.");

        }


    }


}