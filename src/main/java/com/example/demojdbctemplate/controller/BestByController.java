package com.example.demojdbctemplate.controller;

import com.example.demojdbctemplate.model.BestBy;
import com.example.demojdbctemplate.service.IBestByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller endpoint - API.
 *
 */
@RestController
public class BestByController {


    @Autowired
    private IBestByService bestByService;

    /**
     * returns the list of items with the bestby items.
     *
     * @return
     */
    @RequestMapping("/items")
    public ResponseEntity<List<BestBy>> allItems() {
        return ResponseEntity.ok(bestByService.getItems());
    }

}
