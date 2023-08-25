package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Categories;
import com.app.Entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	List<Product> findByProdCategory(Categories categorys);

}
