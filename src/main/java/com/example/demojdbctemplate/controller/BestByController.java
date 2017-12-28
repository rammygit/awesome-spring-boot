package com.example.demojdbctemplate.controller;

import com.example.demojdbctemplate.model.BestBy;
import com.example.demojdbctemplate.service.IBestByService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller endpoint - API.
 *
 */
@RestController
@RequestMapping("/bestby")
public class BestByController {

    private static final Logger logger = LoggerFactory.getLogger(BestByController.class);

    @Autowired
    private IBestByService bestByService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * returns the list of items with the bestby items.
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/items")
    public ResponseEntity<List<BestBy>> allItems() {
        logger.info("all items -> "+bestByService.getItems());
        return ResponseEntity.ok(bestByService.getItems());
    }

    /**
     * get the response using URL
     * http://localhost:port/bestby/item?name=?
     *
     * @param itemName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/item")
    public ResponseEntity<BestBy> getItem(@RequestParam(value = "name") String itemName) {

        return ResponseEntity.ok(bestByService.getItem(itemName));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<BestBy> createItem(@RequestBody BestBy bestBy) {
        logger.info("creating new item into DB.. " + bestBy.getItem());
        return ResponseEntity.ok(bestByService.saveItem(bestBy));
    }

}
