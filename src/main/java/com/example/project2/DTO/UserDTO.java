package com.example.project2.DTO;

import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class UserDTO {
    private int id;
    @Size(min = 3)
    private String name;
    @Past
    private Date birthDate;
    @Size(min = 1)
    private String email;
    @Size(min = 6)
    private String password;
}
