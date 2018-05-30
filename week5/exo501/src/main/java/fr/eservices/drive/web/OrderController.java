package fr.eservices.drive.web;

import fr.eservices.drive.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eservices.drive.repository.OrderRepository;

@Controller
@RequestMapping(path="/order")
public class OrderController {
	
	
	// Autowire this
	@Autowired
	OrderRepository repoOrder;
	
	@RequestMapping(path="/ofCustomer/{custId}.html")
	public String list(@PathVariable String custId, Model model) {
        //Order order = repoOrder;
		// use repo to get orders of a customer
		// assign in model as "orders"
		// return order list view
		
		return "";
	}

}
