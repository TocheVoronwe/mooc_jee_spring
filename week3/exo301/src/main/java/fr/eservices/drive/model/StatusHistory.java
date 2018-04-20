package fr.eservices.drive.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = 'status_history')
public class StatusHistory {
    @Id
    int id;
    Date statusDate;
    Status status;
}
