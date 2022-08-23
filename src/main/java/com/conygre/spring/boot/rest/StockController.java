package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.services.StockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin
public class StockController {
    @Autowired
    private StockService service;

    @ApiOperation(value = "getAllStocks", nickname = "getAllStocks")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Stock> getAllStocks() {
        return service.getAllStocks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{stock_symbol}")
    public Iterable<Stock> getStocksbySymbol(@PathVariable("stock_symbol") String symbol) {
        return service.getStockBySymbol(symbol);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{stock_name}")
    public Iterable<Stock> getStocksbyName(@PathVariable("stock_name") String name) {
        return service.getStocksByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void buyStock(@RequestBody Stock stock) {
        service.buyStock(stock);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void sellStock(@RequestBody Stock stock) {
        service.sellStock(stock);
    }
}
