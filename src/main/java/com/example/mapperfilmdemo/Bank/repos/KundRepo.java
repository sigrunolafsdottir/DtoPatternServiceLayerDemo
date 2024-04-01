package com.example.mapperfilmdemo.Bank.repos;

import com.example.mapperfilmdemo.Bank.models.Kund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundRepo extends JpaRepository<Kund, Long> {
}
