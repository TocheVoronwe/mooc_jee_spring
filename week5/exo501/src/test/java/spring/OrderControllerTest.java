package spring;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;

import fr.eservices.drive.mock.CartMockDao;
import fr.eservices.drive.model.Order;
import fr.eservices.drive.web.OrderController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=OrderControllerTest.class)
@Configuration
@ComponentScan(basePackageClasses={CartMockDao.class})
public class OrderControllerTest {
	
	/*
	 * Configuration du test
	 */
	
	@Bean
	OrderController orderController() {
		return new OrderController();
	}
	
	/*
	 * Tests
	 */
	
	@Autowired
	OrderController ctrl;
	
	
	@Test
	public void list() {
		ExtendedModelMap model = new ExtendedModelMap();
		String view = ctrl.list("chuckNorris", model);
		assertEquals("order_list", view);
		@SuppressWarnings("unchecked")
		List<Order> orders = 
				(List<Order>) model.get("orders");
		assertNotNull(orders);
		
	}

}
