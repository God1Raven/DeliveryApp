package com.example.deliveryapp.repository;

import com.example.deliveryapp.dto.StatusSale;
import com.example.deliveryapp.entity.FindSaleByAddressByAvgRating;
import com.example.deliveryapp.entity.Sale;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByStatus(StatusSale status);

    @Query(value = """
                      SELECT sale.id as id, shopRate.id AS shopId, shopRate.shop_name AS shopName, sale.address AS address FROM sale join
                  (SELECT
                  shop.id id,
                  rate.avg_rating shop_rating,
                  shop.name shop_name
                  FROM
                  shop
                  join (
               SELECT
               shop_id,
               AVG(rating) avg_rating
               FROM
               shop_rating
               group by
               shop_id
            ) rate
            on shop.id = rate.shop_id) shopRate on sale.shop_id = shopRate.id where address = ?1 AND shop_rating >= ?2""", nativeQuery = true)
    List<FindSaleByAddressByAvgRating> findSaleByAddressByAvgRating(String address, double shopRating);

}
