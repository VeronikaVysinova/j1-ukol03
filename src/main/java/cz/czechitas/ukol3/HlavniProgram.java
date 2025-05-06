package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

        System.out.println("Program spuštěn.");

        // ukol 03 - cast 1

        Disk veronikyDisk = new Disk();

        veronikyDisk.setKapacita(510_028_367_200L);
        veronikyDisk.setVyuziteMisto(85_899_345_920L);

        System.out.println(veronikyDisk);

        Pamet veronikyPamet = new Pamet();

        veronikyPamet.setKapacita(17_179_869_184L);

        System.out.println(veronikyPamet);

        Procesor veronikyProcesor = new Procesor();

        veronikyProcesor.setVyrobce("HP");
        veronikyProcesor.setRychlost(2_800_000_000L);

        System.out.println(veronikyProcesor);

        Pocitac veronikyPocitac = new Pocitac();

        veronikyPocitac.setCpu(veronikyProcesor);
        veronikyPocitac.setRam(veronikyPamet);
        veronikyPocitac.setPevnyDisk(veronikyDisk);

        System.out.println(veronikyPocitac);

        veronikyPocitac.zapniSe();
        veronikyPocitac.zapniSe();  //vypise chybu protoze je pocitac jiz zapnuty

        veronikyPocitac.vypniSe();

        veronikyPocitac.vypniSe(); //nic se nevypise, ignoruje opakovane vypnuti


        // ukol 03 - cast 2

        veronikyPocitac.zapniSe();

        veronikyPocitac.vytvorSouborOVelikosti(500000000L); //pridava soubor o zadane velikosti, pokud se vejde na disk

        veronikyPocitac.vymazSouborOVelikosti(5000000L); // maze soubor o zadane velikosti, pokud je to mozne

    }
}
