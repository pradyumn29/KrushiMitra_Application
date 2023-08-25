package com.app.Service.Product;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.ProductDto;
import com.app.Entities.Categories;
import com.app.Entities.Product;
import com.app.Repository.CategoriesRepo;
import com.app.Repository.ProductRepo;
import com.app.exceptions.ProductNotExistsExceptions;
import com.app.exceptions.UserHandlingException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prodRepo;
	@Autowired
	private CategoriesRepo catRepo;
	
	@Override
	public Product addNewProduct(Product newProd, String CategoryName) {
		Categories category=catRepo.findByCategoryNameIgnoreCase(CategoryName).orElseThrow();
		category.addProduct(newProd);
		return prodRepo.save(newProd);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return prodRepo.findAll();
	}

	@Override
	public List<Product> getAllProductByCategory(String CategoryName) {
		Categories category=catRepo.findByCategoryNameIgnoreCase(CategoryName).orElseThrow();
		
		List<Product> product=prodRepo.findByProdCategory(category);
		return product;
	}

	@Override
	public Product getProductById(Long prodID) {
		Product product=prodRepo.findById(prodID).orElseThrow(()->new UserHandlingException(null));
		return product ;
	}

	@Override
	public void removeProduct(Long ProductId) {
		
		prodRepo.deleteById(ProductId);

	}

	@Override
	public Product updateProduct(Product updateProd) {
	  Product product=prodRepo.findById(updateProd.getId()).orElseThrow();
	   product.setProdname(updateProd.getProdname());
	   product.setProdQuantity(updateProd.getProdQuantity());
	   product.setImageUrl(updateProd.getImageUrl());
	   product.setMfgDate(updateProd.getMfgDate());
	   product.setProdCategory(updateProd.getProdCategory());
	   product.setProdDesc(updateProd.getProdDesc());
	   product.setProdWeight(updateProd.getProdWeight());
	   product.setSpecification(updateProd.getSpecification());
	   product.setUnitPrice(updateProd.getUnitPrice());
	   
		return product;
	}

}
