package com.example.project2.Resources;

import com.example.project2.DTO.ProductDTO;
import com.example.project2.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    public ProductDTO createProduct(ProductDTO productDTO);
    public List<ProductDTO> returnAllProducts();
    public ProductDTO findProductById(int id);
    public ProductDTO UpdateProduct(int id, ProductDTO productDTO);
    public void DeleteProduct(int id);
}
