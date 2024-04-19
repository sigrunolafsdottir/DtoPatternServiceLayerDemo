package com.example.mapperfilmdemo.Bank.services.impl;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import com.example.mapperfilmdemo.Bank.services.KontoService;
import com.example.mapperfilmdemo.Bank.services.KundService;
import com.example.mapperfilmdemo.Bank.services.impl.KontoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KundServiceImpl implements KundService {

   // private final KontoService kontoService;
    private final KundRepo kundRepo;

    @Override
    public List<DetailedKundDto> getAllKunder() {
        return kundRepo.findAll().stream().map(k -> kundToDetailedKundDto(k)).toList();
    }

    @Override
    public String addKund(DetailedKundDto kund) {
        kundRepo.save(detailedKundDtoToKund(kund));
        return "Kunden har sparats";
    }

    @Override
    public KundDto kundToKundDto(Kund k) {
        return KundDto.builder().Id(k.getId()).name(k.getName()).build();
    }

    @Override
    public DetailedKundDto kundToDetailedKundDto(Kund k) {
        return DetailedKundDto.builder().Id(k.getId()).ssn(k.getSsn()).name(k.getName())
                .konton(k.getKundKonton().stream()
                        .map(konto -> kontoToKontoDto(konto)).toList()).build();
    }

    //Denna är dubbellagrad
    //Skrev den först i KontoServiceImpl, men det blev problem med testerna så jag
    //var tvungen att skriva en kopia här
    public KontoDto kontoToKontoDto(Konto k) {
        return KontoDto.builder().Id(k.getId()).kontonummer(k.getKontonummer()).build();
    }

    @Override
    public Kund detailedKundDtoToKund(DetailedKundDto k) {
        return Kund.builder().Id(k.getId()).ssn(k.getSsn()).name(k.getName()).build();
    }


}
