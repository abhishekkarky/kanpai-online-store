package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCartRepo extends JpaRepository<ProductCart, Integer> {
}
