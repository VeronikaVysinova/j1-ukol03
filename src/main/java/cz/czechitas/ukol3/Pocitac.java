package cz.czechitas.ukol3;

import java.util.ArrayList;
import java.util.List;
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

    // ukol navic
    private final List<Disk> disky = new ArrayList<>();


    public void pridejDisk(String nazev, long kapacita, long vyuziteMisto) {

        if (jeZapnuty) {
            if(disky.size() >= 5){
                System.err.println("Neni dostatek mista pro pridani " + nazev + ". Max. pocet disku je 5.");
                return;
            }

            disky.add(new Disk(nazev, kapacita, vyuziteMisto));
            System.out.println(seznamDisku());

        } else {
            jeZapnuty = true;
            System.err.println(nazev +" nemuze byt pridan, protoze je pocitac zapnuty.");
        }

    }

    public String seznamDisku(){
        StringBuilder builder = new StringBuilder();
        builder.append("Seznam disku:");
        builder.append(System.lineSeparator());
        for (Disk disk : disky) {
            builder.append("- ");
            builder.append(disk.getNazev() + " ma kapacitu " + disk.getKapacita() + " bajtu a vyuzite misto " + disk.getVyuziteMisto() + " bajtu" + System.lineSeparator());


        }
        return builder.toString();
    }



    public void odeberDisk(String nazev) {
        if (jeZapnuty) {
            disky.remove(disky.size() - 1);
            System.out.println("Byl odstranen " + nazev);
            System.out.println(seznamDisku());
        } else {
            System.err.println(nazev + " nemohl byt odstranen, protoze je pocitac zapnuty.");
        }
    }






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
            System.out.println("Pocitac se zapnul. Stav: " + jeZapnuty);

        }
    }

    public void vypniSe() {
        if (jeZapnuty){
            jeZapnuty = false;
            System.out.println("Pocitac se vypnul. Stav: " + jeZapnuty);

        }


    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Pocitac neni zapnuty, nelze vytvorit soubor.");
            return;
        }

        for (Disk disk : disky) {
            if (disk.getVyuziteMisto() + velikost <= disk.getKapacita()) {
                disk.setVyuziteMisto(disk.getVyuziteMisto() + velikost);
                System.out.println("Soubor byl ulozen na disk: " + disk.getNazev());
                return;
            }
        }

        System.err.println("Soubor se nevejde na zadny z disku.");
    }

    public void vymazSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("Pocitac neni zapnuty, soubor neni mozne vymazat z zadneho disku.");
            return;
        }

        for (Disk disk : disky) {
            if (disk.getVyuziteMisto() >= velikost) {
                disk.setVyuziteMisto(disk.getVyuziteMisto() - velikost);
                System.out.println("Soubor o velikosti " + velikost + " bajtu byl smazan z disku: " + disk.getNazev());
                return;
            }
        }

        System.err.println("Na zadnem z disku neni soubor o danne velikosti.");
    }


}