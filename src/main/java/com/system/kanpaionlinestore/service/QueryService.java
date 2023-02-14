package com.system.kanpaionlinestore.service;

import com.system.kanpaionlinestore.entity.Queries;
import com.system.kanpaionlinestore.pojo.QueriesPojo;

import java.util.List;

public interface QueryService {
    List<Queries> fetchAll();

    String save(QueriesPojo queriesPojo);
}
