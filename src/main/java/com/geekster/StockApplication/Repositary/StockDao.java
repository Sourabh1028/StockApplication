package com.geekster.StockApplication.Repositary;

import com.geekster.StockApplication.Model.Stock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StockDao extends CrudRepository<Stock, Integer> {

    //cstom finder
    public List<Stock> findByStockType(String stockType);

    public List<Stock> findByStockPriceGreaterThanAndStockBirthTimestampLessThanOrderByStockName(Double price, LocalDateTime date);

    //custom queries : native

    @Query(value = "select * from stock where STOCK_MARKET_CAP > :capPercentage", nativeQuery = true)
    public List<Stock> getAllStocksAboveMarketCap(Double capPercentage);

    //update using custom queries
    @Modifying
    @Query(value = "update stock set STOCK_MARKET_CAP =  :capPercentage where STOCK_ID = :id", nativeQuery = true)
    public void updateMarketCapById(Double capPercentage, Integer id);

    //delete
    @Modifying
    @Query(value = "delete from stock where STOCK_OWNER_COUNT <=  :userCount", nativeQuery = true)
    public void deletestockByOwnerCount(Integer userCount);


}
