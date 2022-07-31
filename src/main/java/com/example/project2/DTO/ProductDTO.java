package com.example.project2.DTO;




import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class ProductDTO {
    @NotNull
    private int id;
    @Size(min = 3)
    private String productName;
    @Size(min = 1)
    private double price;
}
