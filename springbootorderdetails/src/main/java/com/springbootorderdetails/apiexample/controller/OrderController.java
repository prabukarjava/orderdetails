package com.springbootorderdetails.apiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springbootorderdetails.apiexample.dao.OrderDAO;
import com.springbootorderdetails.apiexample.model.Order;

@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	OrderDAO orderDAO;
	

	
	 @PostMapping("/Order")
  public Order creatOrder(@Valid @RequestBody Order ord) {
	return orderDAO.save(ord);
	  
  }
	 
  @GetMapping("/Order")
  public List<Order> getAllOrder(){
	  return orderDAO.findAll();
  }
  @GetMapping("/order/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable(value="id") Long orderid){
	  Order ord=orderDAO.findOne(orderid);
	  if(ord==null) {
		  return ResponseEntity.notFound().build();
	  }
	  return ResponseEntity.ok().body(ord);
  }
		
  
  @PutMapping("/order/{id}")
	public ResponseEntity<Order> updateEmployee(@PathVariable(value="id") Long orderid,@Valid @RequestBody Order ordDetails){
		
		
		Order ord=OrderDAO.findOne(orderid);
		if(ord==null) {
			return ResponseEntity.notFound().build();
		}
		
		ord.setOrderid(ordDetails.getOrderid());
		ord.setDate(ordDetails.getDate());
		ord.setStatus(ordDetails.getStatus());
		ord.setItems(ordDetails.getItems());
		
		
		
		Order updateOrder=OrderDAO.save(ord);
		return ResponseEntity.ok().body(updateOrder);
		
		
	}
 

}
