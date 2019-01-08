package com.pdonatilio.simplestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdonatilio.simplestore.domain.PurchaseOrderItem;

@Repository
public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Integer>{

}
