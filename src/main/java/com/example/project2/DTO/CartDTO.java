package com.example.project2.DTO;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CartDTO {
    @NotNull
    private int id;
    private int Size;
    private double totalPrice;
}
