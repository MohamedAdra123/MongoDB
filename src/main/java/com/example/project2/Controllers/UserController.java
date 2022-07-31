package com.example.project2.Controllers;

import com.example.project2.DTO.UserDTO;
import com.example.project2.Resources.Imp.UserResource;
import com.example.project2.DTO.UserDTO;
import com.example.project2.Resources.Imp.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
   private UserResource userResource;

    @GetMapping
    public ResponseEntity<List<UserDTO>> returnAllUsers(){
        return ResponseEntity.ok().body(userResource.returnAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable int id){
        return ResponseEntity.ok().body(userResource.findUserById(id));
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userResource.createUser(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable int id){
        return new ResponseEntity<>(userResource.UpdateUser(id,userDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable int id){
        userResource.DeleteUser(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
