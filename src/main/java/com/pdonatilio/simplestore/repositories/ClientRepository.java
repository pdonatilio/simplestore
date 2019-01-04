package com.pdonatilio.simplestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdonatilio.simplestore.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
