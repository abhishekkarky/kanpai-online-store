package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductTequila;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTequilaRepo extends JpaRepository<ProductTequila, Integer> {

}
