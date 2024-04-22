package com.example.mapperfilmdemo.Bank.services.impl;

import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.dtos.KontoDto;
import com.example.mapperfilmdemo.Bank.dtos.KundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KontoRepo;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
class KundServiceImplTest {

    @Mock
    private KundRepo kundRepo;

    //Injecten verkar inte funka... DÄrför skapar jag servicar längre ner vid behov
    @InjectMocks
    private KundServiceImpl service = new KundServiceImpl(kundRepo);


    long kontoId = 1L;
    long kundId = 2L;
    String kundnamn = "Svenne";
    String ssn="21321423";
    int saldo = 100;
    int ranta = 1;
    String kontonr="123456";

    //i denna klass testar vi "fullskaliga" kunder, men konton har inga kunder kopplade under sig

    Konto konto = new Konto(kontoId, saldo, ranta, kontonr, null );
    Kund kund = new Kund(kundId, kundnamn, ssn, Arrays.asList(konto));
    KundDto kundDto = new KundDto(kundId, kundnamn);
    KontoDto kontoDto = new KontoDto(kontoId, kontonr);

    DetailedKundDto detailedKundDto = DetailedKundDto.builder().Id(kundId)
            .name(kundnamn).ssn(ssn).konton(Arrays.asList(kontoDto)).build();


    @Test
    void getAllKunder() {
        //krångel att injecta repot i servicen längst upp i klassen
        when(kundRepo.findAll()).thenReturn(Arrays.asList(kund));
        KundServiceImpl service2 = new KundServiceImpl(kundRepo);

        List<DetailedKundDto> allKunder = service2.getAllKunder();
        assertTrue(allKunder.size() == 1);
    }

    @Test
    void addKund() {
        //krångel att injecta repot i servicen längst upp i klassen
        when(kundRepo.save(kund)).thenReturn(kund);
        KundServiceImpl service2 = new KundServiceImpl(kundRepo);
        String feedback = service2.addKund(detailedKundDto);
        assertTrue(feedback.equalsIgnoreCase("Kunden har sparats"));
    }

    @Test
    void kundToKundDto() {
        KundDto actual = service.kundToKundDto(kund);

        assertEquals(actual.getId(),kund.getId());
        assertEquals(actual.getName(),kund.getName());
    }

    @Test
    void kundToDetailedKundDto() {
        DetailedKundDto actual = service.kundToDetailedKundDto(kund);

        assertEquals(actual.getId(), detailedKundDto.getId());
        assertEquals(actual.getSsn(), detailedKundDto.getSsn());
        assertEquals(actual.getName(), detailedKundDto.getName());
        assertEquals(actual.getKonton(), detailedKundDto.getKonton());

        assertEquals(actual.getKonton().size(), 1);
        assertEquals(actual.getKonton().get(0).getId(), detailedKundDto.getKonton().get(0).getId());
        assertEquals(actual.getKonton().get(0).getKontonummer(), detailedKundDto.getKonton().get(0).getKontonummer());
    }

    @Test
    void testDetailedKundDtoToKund() {
        Kund actual = service.detailedKundDtoToKund(detailedKundDto);

        assertEquals(actual.getId(), kund.getId());
        assertEquals(actual.getSsn(), kund.getSsn());
        assertEquals(actual.getName(), kund.getName());
        assertEquals(actual.getKundKonton(), null);

    }


}