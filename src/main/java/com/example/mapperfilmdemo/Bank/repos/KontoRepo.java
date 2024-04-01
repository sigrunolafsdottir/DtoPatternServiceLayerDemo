package com.example.mapperfilmdemo.Bank.repos;


import com.example.mapperfilmdemo.Bank.models.Konto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KontoRepo extends JpaRepository<Konto, Long> {
}
