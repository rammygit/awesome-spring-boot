package com.example.demojdbctemplate.repository;

import com.example.demojdbctemplate.model.BestBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA based implementation
 *
 * @author ramkumar
 */
@Repository
public interface JPABestByRepository extends CrudRepository<BestBy, Integer> {


    List<BestBy> findAll();

    BestBy findByItem(String item);


}
