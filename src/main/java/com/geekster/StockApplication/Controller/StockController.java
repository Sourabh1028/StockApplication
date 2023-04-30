package com.geekster.StockApplication.Controller;

import com.geekster.StockApplication.Model.Stock;
import com.geekster.StockApplication.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping(value = "/type/{stockType}")
    public List<Stock> getStockBasedOnType(@PathVariable String stockType){
        return stockService.getStockByType(stockType);
    }

    //get using custom finder
    @GetMapping(value = "abovePrice/price/{price}/lowerData/date/{date}")
    public List<Stock> getStocksAbovePriceAndLowerDate(@PathVariable Double price, @PathVariable String date){
        return stockService.getStocksAbovePriceAndLowerDate(price, date);
    }

    @GetMapping(value = "cap/{capPercentage}")
    public List<Stock> getAllStocksAboveMarketCap(@PathVariable Double capPercentage){
        return stockService.getAllStocksAboveMarketCap(capPercentage);
    }

    @PostMapping(value = "/")
    public String insertStocks(@RequestBody List<Stock> stockType){
        return stockService.addStocks(stockType);
    }

    @PutMapping(value = "/marketCap/{marketCap}/id/{id}")
    public void updateStocks(@PathVariable Double marketCap, @PathVariable Integer id){
         stockService.updateMarket(marketCap, id);
    }

    @DeleteMapping(value = "/ownerCount/{userCount}")
    public void deleteByOwnerCount(@PathVariable Integer userCount){
        stockService.deleteStock(userCount);
    }
}
