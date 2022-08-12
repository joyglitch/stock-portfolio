package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.services.StockService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin // allows requests from all domains
public class StockController {

	private static Logger logger = LogManager.getLogger(StockController.class);

	@Autowired
	private StockService service;

	@ApiOperation(value = "findAll", nickname = "findAll")
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Stock> findAll() {
		logger.info("managed to call a Get request for findAll");
		return service.getAllStocks();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Stock getCdById(@PathVariable("id") int id) {
		return service.getStockById(id);
	}

	@RequestMapping(method=RequestMethod.GET, value="/404/{id}")
	public ResponseEntity<Stock> getByIdWith404(@PathVariable("id") int id) {
		Stock disc = service.getStockById(id);
		if (disc == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(disc, HttpStatus.OK);
		}
	}


	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteCd(@PathVariable("id") int id) {
		service.deleteStock(id);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteCd(@RequestBody Stock disc) {
		service.deleteStock(disc);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addCd(@RequestBody Stock disc) {
		service.addNewStock(disc);
	}

}
