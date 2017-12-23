package com.example.demojdbctemplate.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ramkumar
 *
 */
@Data
public class BestBy {

    private int id;
    private String item;
    private Date bestByDate;

    public BestBy(int id, String item,Date bestByDate){
        this.id = id;
        this.item = item;
        this.bestByDate = bestByDate;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "BestBy{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", bestByDate=" + bestByDate +
                '}';
    }
}
