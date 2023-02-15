package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCartRepo extends JpaRepository<ProductCart, Integer> {

}
