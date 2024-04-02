package com.example.mapperfilmdemo.Bank.dtos;


import com.example.mapperfilmdemo.Bank.models.Kund;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedKontoDto {

    private Long Id;
    private int saldo;
    private int ranta;
    private String kontonummer;
    private KundDto kund;
}
