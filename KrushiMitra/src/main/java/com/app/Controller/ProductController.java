package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Categories;
import com.app.Entities.Product;
import com.app.Service.Product.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	
	@PostMapping("/addprod/{catName}")
	public ResponseEntity<?> addProduct(@RequestBody Product product,@RequestParam String categoryName){
		System.out.println("in controller "+product);
		return new ResponseEntity<>(prodServ.addNewProduct(product, categoryName), HttpStatus.CREATED);
	}
	
	@GetMapping("/productList")
	public List<Product> AllProductList(){
		return prodServ.getAllProduct();
	}
	
	@GetMapping("/categeory/{category}")
	public List<Product> AllProductbyCategory(@PathVariable String category){
		return prodServ.getAllProductByCategory(category);
	}
	
	@GetMapping("/{id}")
	public Product getByProductId(@PathVariable long id)
	{
		return prodServ.getProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id) {
		prodServ.removeProduct(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody Product updateProd){
		return new ResponseEntity<>(prodServ.updateProduct(updateProd), HttpStatus.OK);
	}

}
