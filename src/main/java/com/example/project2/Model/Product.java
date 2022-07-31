package com.example.project2.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document
@Data
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String productName;
    @Column
    private double price;

}
