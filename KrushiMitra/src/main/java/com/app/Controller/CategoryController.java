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
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.Categories;
import com.app.Service.Categories.CategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	@GetMapping("/view")
	public List<Categories> viewAllCategory(){
		return catService.getAllCategory();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> AddCategory(@RequestBody Categories category){
		return new ResponseEntity<>(catService.addNewCategory(category), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCategory(@RequestBody Categories category){
		return new ResponseEntity<>(catService.updateCategory(category), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCategory(@PathVariable Long id) {
		catService.deleteCategory(id);
	}
}
