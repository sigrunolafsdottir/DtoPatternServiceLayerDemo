package com.example.mapperfilmdemo.Bank.dtos;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedKundDto {

    private Long Id;
    private String name;
    private String ssn;
    private List<KontoDto> konton;

}
