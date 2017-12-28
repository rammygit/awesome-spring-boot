package com.example.demojdbctemplate.service;

import com.example.demojdbctemplate.model.BestBy;
import com.example.demojdbctemplate.repository.BestByRepository;
import com.example.demojdbctemplate.repository.JPABestByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.PostConstruct;

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
     * single item information
     * @param itemName
     * @return
     */
    public BestBy getItem(String itemName) {
        return jpaBestByRepository.findByItem(itemName);
    }

    /**
     * @param bestBy
     * @return
     */
    public BestBy saveItem(BestBy bestBy) {
        return jpaBestByRepository.save(bestBy);
    }
}
