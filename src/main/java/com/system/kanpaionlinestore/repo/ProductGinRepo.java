package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductGin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGinRepo extends JpaRepository<ProductGin, Integer> {

}
