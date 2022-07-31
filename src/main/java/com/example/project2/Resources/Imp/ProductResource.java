package com.example.project2.Resources.Imp;

import com.example.project2.DTO.ProductDTO;
import com.example.project2.Exceptions.ResourceNotFoundException;
import com.example.project2.Model.Product;
import com.example.project2.Repositories.ProductRepo;
import com.example.project2.Resources.ProductService;
import com.example.project2.utils.Utilities;
import com.example.project2.DTO.ProductDTO;
import com.example.project2.Exceptions.ResourceNotFoundException;
import com.example.project2.Model.Product;
import com.example.project2.Repositories.ProductRepo;
import com.example.project2.Resources.ProductService;
import com.example.project2.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductResource implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = Utilities.convertProductDTOToEntity(productDTO);
        productRepo.save(product);
        return Utilities.convertProductEntityToDTO(product);
    }

    @Override
    public List<ProductDTO> returnAllProducts() {
        return productRepo.findAll().stream().map(product -> Utilities.convertProductEntityToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductById(int id) {
        Product product=productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","Id",id));
        return Utilities.convertProductEntityToDTO(product);
    }

    @Override
    public ProductDTO UpdateProduct(int id, ProductDTO productDTO) {
        Product product=productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","Id",id));
        product.setProductName(productDTO.getProductName());
        product.setId(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        productRepo.save(product);
        return Utilities.convertProductEntityToDTO(product);
    }

    @Override
    public void DeleteProduct(int id) {
        Product product=productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product","Id",id));
        productRepo.delete(product);
    }
}
