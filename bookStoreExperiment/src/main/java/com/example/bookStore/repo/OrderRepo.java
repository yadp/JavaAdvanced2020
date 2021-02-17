package com.example.bookStore.repo;

import com.example.bookStore.model.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepo extends CrudRepository<Order,Long> {
}
