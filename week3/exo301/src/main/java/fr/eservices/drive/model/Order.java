package fr.eservices.drive.model;

import javax.xml.bind.annotation.XmlID;
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
    List<Article> articles;
    Status currentStatus;
    List<StatusHistory> history;
}
