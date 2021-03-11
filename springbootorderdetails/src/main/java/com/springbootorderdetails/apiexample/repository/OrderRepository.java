package com.springbootorderdetails.apiexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbootorderdetails.apiexample.model.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {

	 @Query("SELECT * FROM order a FULL JOIN item c on a.id=b.id")
	  public List<Order> FindAllWithDescriptionQuery();
}
