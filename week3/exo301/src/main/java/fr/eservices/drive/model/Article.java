package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
    @Id
    int id;
    String ean13;
    float price;
    float vat;
    String name;
    int img;
    Category category;
}
