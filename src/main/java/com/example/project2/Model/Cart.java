package com.example.project2.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TimeSeries;

import javax.persistence.*;
import java.util.List;

@TimeSeries(collection = "weather",timeField = "timeStamp")
@Document
@Data
public class Cart {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int Size;
    @Column
    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

}
