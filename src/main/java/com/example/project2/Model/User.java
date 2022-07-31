package com.example.project2.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Document
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private Date birthDate;
    @Column
    private String email;
    @Column
    private String password;

    @OneToOne
   private Cart cart;
}
