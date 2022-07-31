package com.example.project2.Resources.Imp;

import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.Exceptions.ResourceNotFoundException;
import com.example.project2.Model.Cart;
import com.example.project2.Repositories.CartRepo;
import com.example.project2.Resources.CartService;
import com.example.project2.utils.Utilities;
import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.Exceptions.ResourceNotFoundException;
import com.example.project2.Model.Cart;
import com.example.project2.Repositories.CartRepo;
import com.example.project2.Resources.CartService;
import com.example.project2.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartResource implements CartService {
    @Autowired
    private CartRepo cartRepo;

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        Cart cart = Utilities.convertCartDTOToEntity(cartDTO);
        cartRepo.save(cart);
        return Utilities.convertCartEntityToDTO(cart);
    }

    @Override
    public List<CartDTO> returnAllCarts() {
        return cartRepo.findAll().stream().map(cart -> Utilities.convertCartEntityToDTO(cart)).collect(Collectors.toList());
    }

    @Override
    public CartDTO findCartById(int id) {
        Cart cart = cartRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart","Id",id));
        return Utilities.convertCartEntityToDTO(cart);
    }

    @Override
    public CartDTO UpdateCart(int id, CartDTO cartDTO) {
        Cart cart = cartRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart","Id",id));
        cart.setId(cartDTO.getId());
        cart.setTotalPrice(cartDTO.getTotalPrice());
        cart.setSize(cartDTO.getSize());
        cartRepo.save(cart);
        return Utilities.convertCartEntityToDTO(cart);
    }

    @Override
    public void DeleteCart(int id) {
        Cart cart = cartRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart","Id",id));
        cartRepo.delete(cart);
    }

    @Override
    public CartDTO addProduct(ProductDTO productDTO, int id) {
        Cart cart = cartRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart","Id",id));
        cart.getProducts().add(Utilities.convertProductDTOToEntity(productDTO));
        cart.setTotalPrice(cart.getTotalPrice()+productDTO.getPrice());
        cart.setSize(cart.getSize()+1);
        cartRepo.save(cart);
        return Utilities.convertCartEntityToDTO(cart);
    }
}
