package fr.eservices.drive.repository;

import fr.eservices.drive.dao.OrderDao;
import fr.eservices.drive.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository 
extends OrderDao, CrudRepository<Order, Long>
{
    Order save(Order order);

    List<Order> findByCustomerIdOrderByCreatedOnDesc(String customerId);
}
