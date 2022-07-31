package com.example.project2.Controllers;

import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.Resources.Imp.CartResource;
import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.Resources.Imp.CartResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartResource cartResource;

    @GetMapping
    public ResponseEntity<List<CartDTO>> returnAllCarts(){
        return ResponseEntity.ok().body(cartResource.returnAllCarts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> findCartById(@PathVariable int id){
        return ResponseEntity.ok().body(cartResource.findCartById(id));
    }

    @PostMapping
    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO){
        return new ResponseEntity<CartDTO>(cartResource.createCart(cartDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDTO> updateCart(@RequestBody CartDTO cartDTO,@PathVariable int id){
        return new ResponseEntity<CartDTO>(cartResource.UpdateCart(id,cartDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable int id){
        cartResource.DeleteCart(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<CartDTO> createProductForCart(@RequestBody ProductDTO productDTO, @PathVariable int id){
        return new ResponseEntity<CartDTO>(cartResource.addProduct(productDTO,id),HttpStatus.CREATED);
    }
}
