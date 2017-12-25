package com.example.demojdbctemplate.service;

import com.example.demojdbctemplate.model.BestBy;
import com.example.demojdbctemplate.repository.BestByRepository;
import com.example.demojdbctemplate.repository.JPABestByRepository;
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

    @Autowired
    private JPABestByRepository jpaBestByRepository;

    /**
     * without any filter on BestBy table.
     * @return
     */
    public List<BestBy> getItems(){
        return bestByRepository.getAllBestByItems();
    }

    /**
     * @param id
     * @return
     */
    public BestBy getItem(Integer id) {
        return jpaBestByRepository.findByItem("Juice");
    }
}
