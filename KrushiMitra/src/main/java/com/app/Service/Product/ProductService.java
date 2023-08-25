package com.app.Service.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.Dto.ProductDto;
import com.app.Entities.Product;

@Service
public interface ProductService {
	
    Product addNewProduct(Product newProd,String CategoryName);
    
    List<Product> getAllProduct();
    List<Product>getAllProductByCategory(String CategoryName);
    Product getProductById(Long prodID);
    
    void removeProduct(Long ProductId);
    Product updateProduct(Product updateProd);
    
}
