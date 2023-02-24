package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query(value = "select COUNT(*) from kos_products", nativeQuery = true)
    Long countAllRows();

    Optional<Product> findByName(String name);
}
