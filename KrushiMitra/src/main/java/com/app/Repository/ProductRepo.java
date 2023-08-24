package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
