package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

}
