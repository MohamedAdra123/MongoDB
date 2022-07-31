package com.example.project2.Repositories;

import com.example.project2.Model.User;
import com.example.project2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Integer> {
}
