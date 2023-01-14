package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductVodka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVodkaRepo extends JpaRepository<ProductVodka, Integer> {

}
