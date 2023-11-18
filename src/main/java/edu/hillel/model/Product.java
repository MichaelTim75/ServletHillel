package edu.hillel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private BigDecimal cost;
}
