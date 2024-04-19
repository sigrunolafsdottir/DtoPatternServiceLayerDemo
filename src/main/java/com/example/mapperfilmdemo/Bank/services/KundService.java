package com.example.mapperfilmdemo.Bank.services;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface KundService {

    public KundDto kundToKundDto(Kund k);
    public DetailedKundDto kundToDetailedKundDto(Kund k);

    public Kund detailedKundDtoToKund(DetailedKundDto k);

    public List<DetailedKundDto> getAllKunder();

    public String addKund(DetailedKundDto kund);

}
