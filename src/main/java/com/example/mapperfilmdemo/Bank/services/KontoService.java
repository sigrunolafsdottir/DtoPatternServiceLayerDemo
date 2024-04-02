package com.example.mapperfilmdemo.Bank.services;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KontoRepo;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KontoService  {

    private final KontoRepo kontoRepo;
    private final KundRepo kundRepo;

    public List<DetailedKontoDto> getAllKonton(){
        return kontoRepo.findAll().stream().map(k -> KontoToDetailedKontoDto(k)).toList();
    }

    public void addNewKonto(DetailedKontoDto kontoDTO) {
        Kund kund = kundRepo.findById(kontoDTO.getKund().getId()).get();
        kontoRepo.save(detailedKontoDtoToKonto(kontoDTO, kund));
    }

    public KontoDto KontoToKontoDto(Konto konto){
        return KontoDto.builder().Id(konto.getId()).kontonummer(konto.getKontonummer()).build();
    }

    public DetailedKontoDto KontoToDetailedKontoDto(Konto konto){
        return DetailedKontoDto.builder().Id(konto.getId()).kontonummer(konto.getKontonummer())
                .saldo(konto.getSaldo()).ranta(konto.getRanta())
                .kund(new KundDto(konto.getKund().getId(), konto.getKund().getName())).build();
    }


    public Konto detailedKontoDtoToKonto(DetailedKontoDto konto, Kund kund){
        return Konto.builder().Id(konto.getId()).kontonummer(konto.getKontonummer())
                .saldo(konto.getSaldo()).ranta(konto.getRanta()).kund(kund).build();
    }




}
