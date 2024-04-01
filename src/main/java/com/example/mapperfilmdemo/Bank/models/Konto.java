package com.example.mapperfilmdemo.Bank.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Konto {

    @Id
    @GeneratedValue
    private Long Id;
    private int saldo;
    private int ranta;
    private String kontonummer;

    @ManyToOne
    private Kund kund;

}
