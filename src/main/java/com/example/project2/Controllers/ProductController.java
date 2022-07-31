package com.example.project2.Controllers;

import com.example.project2.DTO.ProductDTO;
import com.example.project2.Resources.Imp.ProductResource;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.Resources.Imp.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductResource productResource;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> returnAllProducts() {
        return ResponseEntity.ok().body(productResource.returnAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(productResource.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<ProductDTO>(productResource.createProduct(productDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,@PathVariable int id){
        return new ResponseEntity<ProductDTO>(productResource.UpdateProduct(id,productDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productResource.DeleteProduct(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }

}
