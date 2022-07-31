package com.example.project2.Resources.Imp;

import com.example.project2.DTO.UserDTO;
import com.example.project2.Exceptions.ResourceNotFoundException;
import com.example.project2.Model.User;
import com.example.project2.Repositories.UserRepo;
import com.example.project2.Resources.UserService;
import com.example.project2.utils.Utilities;
import com.example.project2.DTO.UserDTO;
import com.example.project2.Exceptions.ResourceNotFoundException;
import com.example.project2.Model.User;
import com.example.project2.Repositories.UserRepo;
import com.example.project2.Resources.UserService;
import com.example.project2.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserResource implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<UserDTO> returnAllUsers() {
        List<User> users = userRepo.findAll();

        return users.stream().map(user -> Utilities.convertUserEntityToDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(int id) {

        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        return Utilities.convertUserEntityToDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = Utilities.convertUserDTOtoEntity(userDTO);
        userRepo.save(user);
        return Utilities.convertUserEntityToDTO(user);
    }

    @Override
    public UserDTO UpdateUser(int id, UserDTO userDTO) {
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setBirthDate(userDTO.getBirthDate());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        userRepo.save(user);
        return Utilities.convertUserEntityToDTO(user);
    }

    @Override
    public void DeleteUser(int id) {
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        userRepo.delete(user);
    }
}
