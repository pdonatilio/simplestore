package com.pdonatilio.simplestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdonatilio.simplestore.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
