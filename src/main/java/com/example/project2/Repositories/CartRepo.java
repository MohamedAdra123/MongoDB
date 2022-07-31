package com.example.project2.Repositories;

import com.example.project2.Model.Cart;
import com.example.project2.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepo extends MongoRepository<Cart,Integer> {
}
