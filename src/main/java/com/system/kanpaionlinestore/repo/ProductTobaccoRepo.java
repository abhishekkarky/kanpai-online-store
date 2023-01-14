package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTobaccoRepo extends JpaRepository<ProductTobacco, Integer> {

}
