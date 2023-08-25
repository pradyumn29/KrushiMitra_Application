package com.app.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Categories;
@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long> {

	Optional<Categories>findByCategoryNameIgnoreCase(String Catname);
}
