package com.springbootorderdetails.apiexample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.springbootorderdetails.apiexample.model.Order;
import com.springbootorderdetails.apiexample.repository.OrderRepository;

public class OrderDAO {
	
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order save(Order ord) {
		return orderRepository.save(ord);
		
	}
	public List<Order> findAll(){
		return orderRepository.findAll();
		
	}
	
	public Order findOne(Long orderid) {
		return orderRepository.findOne(orderid);
	}

}
