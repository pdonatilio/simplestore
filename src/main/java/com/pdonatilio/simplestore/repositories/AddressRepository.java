package com.pdonatilio.simplestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdonatilio.simplestore.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
