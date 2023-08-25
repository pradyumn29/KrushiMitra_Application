package com.app.Service.Categories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.Categories;
import com.app.Repository.CategoriesRepo;
import com.app.exceptions.UserHandlingException;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoriesRepo catRepo;
	
	
	@Override
	public List<Categories> getAllCategory() {
		
		return catRepo.findAll();
	}

	@Override
	public Categories addNewCategory(Categories category) {
		
		return catRepo.save(category);
	}

	@Override
	public Categories updateCategory(Categories category) {
		Optional<Categories> findcategory=catRepo.findById(category.getId());
		
		if(findcategory.get()!=null) {
			findcategory.get().setCategoryName(category.getCategoryName());
			findcategory.get().setCategoryDesc(category.getCategoryDesc());
			findcategory.get().setImageUrl(category.getImageUrl());
			Categories cat=catRepo.save(findcategory.get());
			return cat;
		}else {
			throw new UserHandlingException("category not found");
		}

	}

	@Override
	public String deleteCategory(Long CatId) {
		Categories cat=catRepo.findById(CatId).orElseThrow();
		 catRepo.delete(cat);
		 return "category deteleted";
	}

}
