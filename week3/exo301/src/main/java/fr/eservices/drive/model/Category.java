package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue
    int id;
    String name;
    int orderIdx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderIdx(int orderIdx) {
        this.orderIdx = orderIdx;
    }

    public int getOrderIdx()
    {
        return orderIdx;
    }

}
