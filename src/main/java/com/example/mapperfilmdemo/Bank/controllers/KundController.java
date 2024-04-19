package com.example.mapperfilmdemo.Bank.controllers;


import com.example.mapperfilmdemo.Bank.dtos.DetailedKundDto;
import com.example.mapperfilmdemo.Bank.models.Kund;
import com.example.mapperfilmdemo.Bank.repos.KundRepo;
import com.example.mapperfilmdemo.Bank.services.KundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class KundController {
    private final KundService kundService;

    @RequestMapping("kunder")
    public List<DetailedKundDto> getAllKunder(){
        return kundService.getAllKunder();
    }

    @PostMapping("kunder/add")
    public String addKund(@RequestBody DetailedKundDto kund){
        return kundService.addKund(kund);
    }

}


