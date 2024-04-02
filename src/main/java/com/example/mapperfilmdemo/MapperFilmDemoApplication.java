package com.example.mapperfilmdemo;

import com.example.mapperfilmdemo.Bank.models.*;
import com.example.mapperfilmdemo.Bank.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MapperFilmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapperFilmDemoApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner demo(KundRepo kundRepo, KontoRepo kontoRepo) {
        return (args) -> {

            Kund kund1 = new Kund(null, "Adde","198604031234", null);
            Kund kund2 = new Kund(null, "Berit", "195902031234", null);
            Kund kund3 = new Kund(null, "Cissi", "19720403114", null);

            kundRepo.save(kund1);
            kundRepo.save(kund2);
            kundRepo.save(kund3);

            Konto konto1 = new Konto(null, 1000, 2, "5784857464", kund1);
            Konto konto2 = new Konto(null, 1000, 2, "5784857465", kund2);
            Konto konto3 = new Konto(null, 1000, 2, "5784857466", kund3);
            Konto konto3 = new Konto(null, 5000, 2, "5784857467", kund3);

            kontoRepo.save(konto1);
            kontoRepo.save(konto2);
            kontoRepo.save(konto3);


        };
    }*/
}


/*
//Denna Bootstrapping-metod används i 1-N-filmen
    @Bean
    public CommandLineRunner demo(KpiRepo kpirepo, KundRepo kundRepo, KategoriRepo katRepo){
        return (args) -> {
            Kpi k1 = new Kpi(45);
            Kpi k2 = new Kpi(76);
            Kpi k3 = new Kpi(3);

            Kategori kat1 = new Kategori("guld");
            Kategori kat2 = new Kategori("silver");
            Kategori kat3 = new Kategori("brons");

            //Vill inte cascada kategorierna pga N-1, och pga "on delete cascade" inte önskvärt beteende
            katRepo.save(kat1);
            katRepo.save(kat2);
            katRepo.save(kat3);

            Kund kund1 = new Kund("Mimmi", "435255", k1, kat1);
            Kund kund2 = new Kund("Börje", "435255", k2, kat1);
            Kund kund3 = new Kund("Elvis", "435255", k3, kat3);

            kundRepo.save(kund1);
            kundRepo.save(kund2);
            kundRepo.save(kund3);

        };
    } */
