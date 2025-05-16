package cz.czechitas.ukol3;

import java.util.List;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {

        System.out.println("Program spuštěn.");

        // ukol 03 - cast 1

        Disk veronikyDisk = new Disk("Disk1",510_028_367_200L,85_899_345_920L);

      //  veronikyDisk.setKapacita(510_028_367_200L);
      //  veronikyDisk.setVyuziteMisto(85_899_345_920L);

         System.out.println(veronikyDisk);

        Pamet veronikyPamet = new Pamet();

        veronikyPamet.setKapacita(17_179_869_184L);

      //  System.out.println(veronikyPamet);

        Procesor veronikyProcesor = new Procesor();

        veronikyProcesor.setVyrobce("HP");
        veronikyProcesor.setRychlost(2_800_000_000L);

        System.out.println(veronikyProcesor);

        Pocitac veronikyPocitac = new Pocitac();

        veronikyPocitac.setCpu(veronikyProcesor);
        veronikyPocitac.setRam(veronikyPamet);
        veronikyPocitac.setPevnyDisk(veronikyDisk);

      //  System.out.println(veronikyPocitac);

        veronikyPocitac.zapniSe();
        veronikyPocitac.zapniSe();  //vypise chybu protoze je pocitac jiz zapnuty

        veronikyPocitac.vypniSe();

        veronikyPocitac.vypniSe();
        veronikyPocitac.zapniSe();

        veronikyPocitac.vypniSe();

      /*  veronikyPocitac.pridejDisk("Disk1",274_877_906_944L);  //pridaji se nove disky
        veronikyPocitac.pridejDisk("Disk2",549_755_813_888L);
        veronikyPocitac.pridejDisk("Disk3",1_099_511_627_776L);

        veronikyPocitac.zapniSe();

        veronikyPocitac.pridejDisk("Disk4",2_199_023_255_552L); //disky se nemohou pridat, protoze je pc vypnuty - error hlaska
        veronikyPocitac.pridejDisk("Disk5",4_398_046_511_104L);

        veronikyPocitac.vypniSe();



        veronikyPocitac.zapniSe();

        veronikyPocitac.odeberDisk("Disk2"); //neodebere disk, protoze je pc zapnuty - error hlaska

        veronikyPocitac.vypniSe();

         */

        veronikyPocitac.pridejDisk("Disk1",510_028_367_200L,85_899_345_920L);
        veronikyPocitac.pridejDisk("Disk2",274_877_906_944L,0);
        veronikyPocitac.pridejDisk("Disk3",549_755_813_888L,0);
        veronikyPocitac.pridejDisk("Disk4",1_099_511_627_776L,0);
        veronikyPocitac.pridejDisk("Disk5",12_199_023_255_552L,0);


        veronikyPocitac.pridejDisk("Disk6",199_023_255_552L,0);



        //veronikyPocitac.vytvorSouborOVelikosti(520_028_367_200L);


    }
}