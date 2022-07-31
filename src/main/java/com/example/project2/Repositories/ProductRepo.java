package com.example.project2.Repositories;

import com.example.project2.Model.Product;
import com.example.project2.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,Integer> {
}
