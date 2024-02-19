package com.example.deliveryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public interface FindByDateSortByRating {

    Long getId();
    String getProductName();
    String getShopName();
    Double getShopRating();

}
