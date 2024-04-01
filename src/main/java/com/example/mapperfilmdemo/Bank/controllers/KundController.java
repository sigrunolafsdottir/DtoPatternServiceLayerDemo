package com.example.mapperfilmdemo.Bank.controllers;


import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KundController {

    private final KundRepo kundRepo;

    KundController(KundRepo kundRepo){
        this.kundRepo=kundRepo;
    }

    @RequestMapping("kunder")
    public List<Kund> getAllKunder(){
        return kundRepo.findAll();
    }

}
