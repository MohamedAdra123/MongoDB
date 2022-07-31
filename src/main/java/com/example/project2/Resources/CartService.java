package com.example.project2.Resources;

import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;

import java.util.List;

public interface CartService {
    public CartDTO createCart(CartDTO cartDTO);
    public List<CartDTO> returnAllCarts();
    public CartDTO findCartById(int id);
    public CartDTO UpdateCart(int id,CartDTO cart);
    public void DeleteCart(int id);
    public CartDTO addProduct(ProductDTO productDTO, int id);
}
