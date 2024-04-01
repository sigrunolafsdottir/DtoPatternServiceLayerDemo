package com.example.mapperfilmdemo.Bank.controllers;


import com.example.mapperfilmdemo.Bank.models.Konto;
import com.example.mapperfilmdemo.Bank.repos.KontoRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KontoController {

    private final KontoRepo kontoRepo;

    KontoController(KontoRepo kontoRepo){
        this.kontoRepo=kontoRepo;
    }

    @RequestMapping("konton")
    public List<Konto> getAllKonton(){
        return kontoRepo.findAll();
    }

}
