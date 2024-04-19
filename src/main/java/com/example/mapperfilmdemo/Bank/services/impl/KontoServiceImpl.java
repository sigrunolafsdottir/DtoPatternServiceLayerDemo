package com.example.mapperfilmdemo.Bank.services.impl;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KontoRepo;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import com.example.mapperfilmdemo.Bank.services.KontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KontoServiceImpl implements KontoService {

    final private KontoRepo kr;
    final private KundRepo kundRepo;

    @Override
    public List<DetailedKontoDto> getAllKonto() {
        return kr.findAll().stream().map(k-> kontoToDtailedKontoDto(k)).toList();
    }

    @Override
    public String addKonto(DetailedKontoDto konto) {
        Kund kund = kundRepo.findById(konto.getKund().getId()).get();
        kr.save(detailedKontoDtoToKonto(konto, kund));
        return "Konto sparades";
    }

    @Override
    public KontoDto kontoToKontoDto(Konto k) {
        return KontoDto.builder().Id(k.getId()).kontonummer(k.getKontonummer()).build();
    }

    @Override
    public DetailedKontoDto kontoToDtailedKontoDto(Konto k) {
        return DetailedKontoDto.builder().Id(k.getId()).saldo(k.getSaldo())
                .ranta(k.getRanta()).kontonummer(k.getKontonummer())
                .kund(new KundDto(k.getKund().getId(), k.getKund().getName())).build();
    }

    @Override
    public Konto detailedKontoDtoToKonto(DetailedKontoDto k, Kund kund) {
        return Konto.builder().Id(k.getId()).ranta(k.getRanta()).saldo(k.getSaldo())
                .kontonummer(k.getKontonummer()).kund(kund).build();
    }


}
