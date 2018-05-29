package fr.eservices.drive.web;

import java.util.List;

import fr.eservices.drive.dao.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.eservices.drive.dao.StatusHistory;

// define as a REST Controller in spring context
@RestController
@RequestMapping(path = "getHistory/")
public class RestHistoryController {
	
	// Inject reference from spring context
	@Autowired HistorySource historySource;

	// map this opetation to GET only
	@GetMapping(path = "")
	public List<StatusHistory> getHistory( @PathVariable int orderId ) {
		return historySource.orderHistory(orderId);
		//throw new RuntimeException("Not yet implemented");
	}
	
	// map this operation to POST only
	@PostMapping(path = "")
	public String addStatus( @PathVariable int orderId, @RequestBody StatusHistory history ) {
		try {
			historySource.addHistoryStatus(orderId, history);
			return "Ok";
		}
		catch (DataException de)
		{
			de.printStackTrace();
			return "Error";
		}
		// try to add a status,
		// return "Ok" or "Error" if exception thrown 

	}
}
