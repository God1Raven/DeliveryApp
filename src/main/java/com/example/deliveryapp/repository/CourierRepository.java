package com.example.deliveryapp.repository;

import com.example.deliveryapp.entity.Courier;
import com.example.deliveryapp.entity.FindCourierByProduct;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    @Query(value = """
                 SELECT t.courier_id as id, t.cid as name, product.name as productName, t.shop_name as shopName, t.shop_rating as shopRating FROM product JOIN
                 (SELECT t.product_id, t.shop_name, t.shop_rating, t.courier_id, courier.name AS cid  FROM courier JOIN
                 (SELECT order_product.product_id, t.shop_name, t.shop_rating, t.courier_id FROM order_product JOIN
                 (SELECT sale.id id, shopRate.shop_rating, shopRate.shop_name, sale.courier_id FROM sale JOIN
              (SELECT
               shop.id id,
               rate.avg_rating shop_rating,
               shop.name shop_name
               FROM
               shop
               JOIN (
            SELECT
            shop_id,
            AVG(rating) avg_rating
            FROM
            shop_rating
            GROUP BY
            shop_id
               ) rate
               ON shop.id = rate.shop_id) shopRate ON sale.shop_id = shopRate.id) t ON order_product.order_id = t.id) t ON courier.id = t.courier_id) t
                  ON product.id = t.product_id where product.name = ?1 AND t.shop_rating >= ?2""", nativeQuery = true)
    List<FindCourierByProduct> findCouriersByProduct(String productName, double shopRating);
}
