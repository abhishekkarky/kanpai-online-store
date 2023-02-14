package com.system.kanpaionlinestore.service.impl;

import com.system.kanpaionlinestore.config.PasswordEncoderUtil;
import com.system.kanpaionlinestore.entity.Queries;
import com.system.kanpaionlinestore.entity.User;
import com.system.kanpaionlinestore.pojo.QueriesPojo;
import com.system.kanpaionlinestore.repo.QueriesRepo;
import com.system.kanpaionlinestore.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {
    private final QueriesRepo queriesRepo;

    @Override
    public List<Queries> fetchAll() {
        return this.queriesRepo.findAll();
    }

    @Override
    public String save(QueriesPojo queriesPojo) {
        Queries queries=new Queries();
        queries.setName(queriesPojo.getName());
        queries.setEmail(queriesPojo.getEmail());
        queries.setSubject(queriesPojo.getSubject());
        queries.setMessage(queriesPojo.getMessage());
        queriesRepo.save(queries);
        return "saved";
    }
}
