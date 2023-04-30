package com.geekster.StockApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer StockId;

    @Column(unique = true)
    private String stockName;

    private LocalDateTime stockBirthTimestamp;

    private Double stockPrice;

    private Integer stockOwnerCount;

    private String stockType;

    private Double stockMarketCap;

}
