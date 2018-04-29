package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    int id;
    String name;
    int orderIdx;
}
