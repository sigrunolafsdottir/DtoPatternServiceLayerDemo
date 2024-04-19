package com.example.mapperfilmdemo.Bank.controllers;


import com.example.mapperfilmdemo.Bank.dtos.DetailedKontoDto;
import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.repos.KontoRepo;
import com.example.mapperfilmdemo.Bank.services.KontoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class KontoController {

    private final KontoService kontoService;

    @RequestMapping("konton")
    public List<DetailedKontoDto> getAllKonton(){
        return kontoService.getAllKonto();
    }

    @PostMapping("konton/add")
    public String addKonto(@RequestBody DetailedKontoDto konto){
        return kontoService.addKonto(konto);
    }



}
