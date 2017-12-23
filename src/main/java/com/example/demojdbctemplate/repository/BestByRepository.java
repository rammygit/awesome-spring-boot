package com.example.demojdbctemplate.repository;

import com.example.demojdbctemplate.model.BestBy;
import com.example.demojdbctemplate.model.Customer;
import com.example.demojdbctemplate.util.QueryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ramkumar
 * @Project demojdbctemplate
 *
 * Connects to in-memory DB using JDBC.
 **/
@Repository
public class BestByRepository {

    private Logger log = LoggerFactory.getLogger(BestByRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * to load after the bean init.
     *
     */
    @PostConstruct
    public void initDB(){

        log.info("initializing DB .... ");

        jdbcTemplate.execute("DROP TABLE BestBy IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE BestBy(" +
                "id SERIAL, item VARCHAR(255), bestbyDate TIMESTAMP)");

        // Split up the array of whole names into an array of item and bestBy date.
        List<Object[]> splitUpNames = Arrays.asList("Juice#2017-12-31 23:59:59", "Rice#2017-12-30 23:59:59").stream()
                .map(name -> name.split("#"))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        //splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO BestBy(item, bestByDate) VALUES (?,?)", splitUpNames);

        log.info("Querying for bestBy records where name = 'Juice':");
        jdbcTemplate.query(
                "SELECT id, item, bestByDate FROM BestBy WHERE item = ?", new Object[] { "Juice" },
                (rs, rowNum) -> new BestBy(rs.getInt("id"), rs.getString("item"), rs.getDate("bestByDate"))
        ).forEach(bestBy -> log.info(bestBy.toString()));
    }

    /**
     * get all the items from DB without any filter.
     * @return
     * @throws Exception
     */
    public List<BestBy> getAllBestByItems(){
        return jdbcTemplate.query(QueryUtil.getAllBestBy,
                (rs, rowNum) -> new BestBy(rs.getInt("id"), rs.getString("item"), rs.getDate("bestByDate")));
    }

}
