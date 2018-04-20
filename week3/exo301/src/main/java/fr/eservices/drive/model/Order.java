package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")

public class Order {
    @Id
    int id;
    Date createdOn;
    Date deliveryDate;
    int amount;
    @ManyToMany
    List<Article> articles;
    Status currentStatus;
    @ManyToMany
    List<StatusHistory> history;
}
