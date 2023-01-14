package com.system.kanpaionlinestore.repo;

import com.system.kanpaionlinestore.entity.ProductWine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWineRepo extends JpaRepository<ProductWine, Integer> {

}
