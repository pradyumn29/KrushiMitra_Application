package com.app.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

	List<Orders>findByUser(Long id);

	void save(List<Orders> orderDetails);    
}
