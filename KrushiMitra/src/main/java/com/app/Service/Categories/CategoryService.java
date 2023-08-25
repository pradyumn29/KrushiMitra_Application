package com.app.Service.Categories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Entities.Categories;

@Service
public interface CategoryService {

	List<Categories> getAllCategory();
	
	Categories addNewCategory(Categories category);
	
	Categories updateCategory(Categories category);
	
	String deleteCategory(Long CatId);
}
