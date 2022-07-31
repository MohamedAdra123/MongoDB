package com.example.project2.Resources;

import com.example.project2.DTO.UserDTO;
import com.example.project2.DTO.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> returnAllUsers();
    public UserDTO findUserById(int id);
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO UpdateUser(int id,UserDTO userDTO);
    public void DeleteUser(int id);
}
