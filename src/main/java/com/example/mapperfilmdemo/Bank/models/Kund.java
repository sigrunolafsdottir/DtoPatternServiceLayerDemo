package com.example.mapperfilmdemo.Bank.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Kund {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String ssn;


    @OneToMany(mappedBy = "kund")
    private List<Konto> kundKonton;


}
