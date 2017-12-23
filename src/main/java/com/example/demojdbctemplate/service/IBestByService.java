package com.example.demojdbctemplate.service;

import com.example.demojdbctemplate.model.BestBy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ramkumar
 * interface for BestByService
 */

public interface IBestByService {

    List<BestBy> getItems();

}
