package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductWhiskey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWhiskeyRepo extends JpaRepository<ProductWhiskey, Integer> {

}
