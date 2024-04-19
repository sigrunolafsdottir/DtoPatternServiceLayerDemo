package com.example.mapperfilmdemo.Bank.services;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;

import java.util.List;

public interface KontoService {

    public KontoDto kontoToKontoDto(Konto k);
    public DetailedKontoDto kontoToDtailedKontoDto(Konto k);

    public Konto detailedKontoDtoToKonto(DetailedKontoDto k, Kund kund);

    public List<DetailedKontoDto> getAllKonto();

    public String addKonto(DetailedKontoDto konto);

}


