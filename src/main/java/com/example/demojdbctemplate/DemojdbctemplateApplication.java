package com.example.demojdbctemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemojdbctemplateApplication{

    private static final Logger log = LoggerFactory.getLogger(DemojdbctemplateApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {

	    SpringApplication.run(DemojdbctemplateApplication.class, args);
	}




}

