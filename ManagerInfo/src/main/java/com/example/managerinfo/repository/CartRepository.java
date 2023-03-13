package com.example.managerinfo.repository;

import com.example.managerinfo.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    Cart findByCustomerIdAndIsDeleted(Long customerId, boolean isDeleted);
}
