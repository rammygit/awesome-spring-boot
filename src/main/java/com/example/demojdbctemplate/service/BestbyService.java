package com.example.demojdbctemplate.service;

import com.example.demojdbctemplate.model.BestBy;
import com.example.demojdbctemplate.repository.BestByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ramkumar
 * @Project demojdbctemplate
 *
 * This wraps the JDBC repository.
 **/
@Component("IBestByService")
@Transactional
public class BestbyService implements IBestByService{

    @Autowired
    private BestByRepository bestByRepository;

    /**
     * without any filter on BestBy table.
     * @return
     */
    public List<BestBy> getItems(){
        return bestByRepository.getAllBestByItems();
    }
}
