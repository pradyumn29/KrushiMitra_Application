package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
