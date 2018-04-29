package fr.eservices.drive.model;

import javax.persistence.*;

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
    @ManyToOne
    Category category;
}
