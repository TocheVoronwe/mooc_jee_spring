package fr.eservices.drive.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "status_history")
public class StatusHistory {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Id

    int id;
    @Temporal(TemporalType.DATE)
    Date statusDate;
    Status status;
    @ManyToOne
    Customer customer;
}
