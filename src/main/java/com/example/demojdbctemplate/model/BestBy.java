package com.example.demojdbctemplate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ramkumar
 *
 */
@Data
@Entity(name = "BestBy")
@Table(name = "BestBy")
public class BestBy {


    @Id
    private int id;
    private String item;
    private Date bestByDate;

    //to make JPA happy
    protected BestBy() {
    }

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
