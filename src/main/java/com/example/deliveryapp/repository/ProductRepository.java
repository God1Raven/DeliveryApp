package com.example.deliveryapp.repository;

import com.example.deliveryapp.entity.FindByDateSortByRating;
import com.example.deliveryapp.entity.Product;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT product.id, product.name AS productName, t.shop_name AS shopName, t.shop_rating AS shopRating FROM product join
            (SELECT order_product.product_id, t.shop_name, t.shop_rating from order_product join
            (SELECT sale.id id, shopRate.shop_rating, shopRate.shop_name FROM sale join
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
             on shop.id = rate.shop_id) shopRate on sale.shop_id = shopRate.id where sale.delivery_date between ?1 and ?2) t on order_product.order_id = t.id) t
            on product.id = t.product_id order by t.shop_rating desc;""", nativeQuery = true)
    List<FindByDateSortByRating> findByDateSortByRating(LocalDate after, LocalDate before);

    // @Modifying
    // @Query(value = "INSERT", )
    // void updateSjasjhdj();
}
