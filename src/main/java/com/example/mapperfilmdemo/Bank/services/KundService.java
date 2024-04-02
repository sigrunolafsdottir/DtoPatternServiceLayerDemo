package com.example.mapperfilmdemo.Bank.services;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KundService {

    private final KundRepo kundRepo;
    private final KontoService kontoService;

    public List<DetailedKundDto> getAllCustomers(){
        return kundRepo.findAll().stream().map(k -> kundToDetailedKundDto(k)).toList();
    }

    public void addNewKund(DetailedKundDto kund){
        kundRepo.save(detailedKundDtoToKund(kund));
    }

    public Kund detailedKundDtoToKund(DetailedKundDto kund){
        return Kund.builder().Id(kund.getId()).ssn(kund.getSsn()).name(kund.getName()).build();
    }


    public KundDto KundToKundDto(Kund kund){
        return KundDto.builder().Id(kund.getId()).name(kund.getName()).build();
    }

    public DetailedKundDto kundToDetailedKundDto(Kund kund){
        return DetailedKundDto.builder().Id(kund.getId()).name(kund.getName())
                .ssn(kund.getSsn())
                .konton(kund.getKundKonton().stream()
                        .map(k -> kontoService.KontoToKontoDto(k)).toList()).build();
    }

}
