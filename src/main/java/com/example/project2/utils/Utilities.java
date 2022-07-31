package com.example.project2.utils;

import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.DTO.UserDTO;
import com.example.project2.Model.Cart;
import com.example.project2.Model.Product;
import com.example.project2.Model.User;
import com.example.project2.DTO.CartDTO;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.DTO.UserDTO;
import com.example.project2.Model.Cart;
import com.example.project2.Model.Product;
import com.example.project2.Model.User;

public class Utilities {
    public static User convertUserDTOtoEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setBirthDate(userDTO.getBirthDate());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
    public static UserDTO convertUserEntityToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
    public static Cart convertCartDTOToEntity(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setSize(cartDTO.getSize());
        cart.setTotalPrice(cartDTO.getTotalPrice());
        return cart;
    }
    public static CartDTO convertCartEntityToDTO(Cart cart){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setSize(cart.getSize());
        cartDTO.setTotalPrice(cart.getTotalPrice());
        return cartDTO;
    }
    public static Product convertProductDTOToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setId(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        return product;
    }
    public static ProductDTO convertProductEntityToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(product.getProductName());
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
