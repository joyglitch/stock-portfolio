package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.entities.Stock;
import com.conygre.spring.boot.entities.Transaction;
import com.conygre.spring.boot.services.StockService;
import com.conygre.spring.boot.services.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController{
    @Autowired
    private TransactionService service;

    @ApiOperation(value = "getAllTransactions", nickname = "getAllTransactions")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void buyStock(@RequestBody Stock stock) {
//        service.buyStock(stock);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    public void sellStock(@RequestBody Stock stock) {
//        service.sellStock(stock);
//    }
}
