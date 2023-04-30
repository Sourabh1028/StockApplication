package com.geekster.StockApplication.Service;

import com.geekster.StockApplication.Model.Stock;
import com.geekster.StockApplication.Repositary.StockDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    @Autowired
    StockDao stockDao;

    public List<Stock> getStockByType(String stockType) {
        return stockDao.findByStockType(stockType);
    }

    public String addStocks(List<Stock> stockList) {
        Iterable<Stock> list = stockDao.saveAll(stockList);
        if (list != null) return "Added list of Stocks....!!!";
        else{
            return "Could not added....!!!";
        }
    }

    public List<Stock> getStocksAbovePriceAndLowerDate(Double price, String date) {
        LocalDateTime myDate= LocalDateTime.parse(date);
        return stockDao.findByStockPriceGreaterThanAndStockBirthTimestampLessThanOrderByStockName(price, myDate);
    }

    public List<Stock> getAllStocksAboveMarketCap(Double capPercentage) {
        return stockDao.getAllStocksAboveMarketCap(capPercentage);
    }

    @Transactional
    public void updateMarket(Double marketCap, Integer id) {
        stockDao.updateMarketCapById(marketCap, id);
    }

    @Transactional
    public void deleteStock(Integer userCount) {
        stockDao.deletestockByOwnerCount(userCount);
    }
}
