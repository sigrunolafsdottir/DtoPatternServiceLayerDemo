package com.example.mapperfilmdemo.Bank.services.impl;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KontoRepo;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class KontoServiceImplTest {

    @Mock
    private KontoRepo kontoRepo;

    @Mock
    private KundRepo kundRepo;

    @InjectMocks
    private KontoServiceImpl service = new KontoServiceImpl(kontoRepo, kundRepo);

    long kontoId = 1L;
    long kundId = 2L;
    String kundnamn = "Svenne";
    String ssn="21321423";
    int saldo = 100;
    int ranta = 1;
    String kontonr="123456";

    //i denna klass testar vi "fullskaliga" konton, men kunden har inga konton kopplade under sig
    Kund kund = new Kund(kundId, kundnamn, ssn, null);
    Konto konto = new Konto(kontoId, saldo, ranta, kontonr, kund );
    KundDto kundDto = new KundDto(kundId, kundnamn);

    KontoDto kontoDto = new KontoDto(kontoId, kundnamn);
    DetailedKontoDto detailedKontoDto = DetailedKontoDto.builder().Id(kontoId)
            .ranta(ranta).saldo(saldo).kontonummer(kontonr).kund(kundDto).build();


    @Test
    void getAllKonto() {
        when(kontoRepo.findAll()).thenReturn(Arrays.asList(konto));
        KontoServiceImpl service2 = new KontoServiceImpl(kontoRepo, kundRepo);
        List<DetailedKontoDto> allKontos = service2.getAllKonto();

        assertTrue(allKontos.size() == 1);
    }

    @Test
    void addKonto() {
        when(kontoRepo.save(konto)).thenReturn(konto);
        when(kundRepo.findById(konto.getKund().getId())).thenReturn(Optional.ofNullable(kund));
        KontoServiceImpl service2 = new KontoServiceImpl(kontoRepo, kundRepo);

        String feedback = service2.addKonto(detailedKontoDto);
        System.out.println("feedback"+feedback);
        assertTrue(feedback.equalsIgnoreCase("Konto sparades"));
    }

    @Test
    void kontoToKontoDto() {
        KontoDto actual = service.kontoToKontoDto(konto);

        assertEquals(actual.getId(), konto.getId());
        assertEquals(actual.getKontonummer(), konto.getKontonummer());
    }


    @Test
    void kontoToDtailedKontoDto() {

        DetailedKontoDto actual = service.kontoToDtailedKontoDto(konto);

        assertEquals(actual.getId(), detailedKontoDto.getId());
        assertEquals(actual.getSaldo(), detailedKontoDto.getSaldo());
        assertEquals(actual.getRanta(), detailedKontoDto.getRanta());
        assertEquals(actual.getKontonummer(),  detailedKontoDto.getKontonummer());

        assertEquals(actual.getKund().getName(),  detailedKontoDto.getKund().getName());
        assertEquals(actual.getKund().getId(),  detailedKontoDto.getKund().getId());
    }

    @Test
    void detailedKontoDtoToKonto() {

        Konto actual = service.detailedKontoDtoToKonto(detailedKontoDto, kund);

        assertEquals(actual.getId(), konto.getId());
        assertEquals(actual.getSaldo(), konto.getSaldo());
        assertEquals(actual.getRanta(), konto.getRanta());
        assertEquals(actual.getKontonummer(), konto.getKontonummer());

        assertEquals(actual.getKund().getName(), konto.getKund().getName());
        assertEquals(actual.getKund().getId(), konto.getKund().getId());
        assertEquals(actual.getKund().getSsn(), konto.getKund().getSsn());

    }
}