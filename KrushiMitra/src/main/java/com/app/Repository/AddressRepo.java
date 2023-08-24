package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
