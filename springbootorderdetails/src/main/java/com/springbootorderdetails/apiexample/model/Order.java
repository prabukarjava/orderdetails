package com.springbootorderdetails.apiexample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Order")
@EntityListeners(AuditingEntityListener.class)
public class Order {
	
	public Order() {
		
	}
	
	public Order(Long orderid, Date date, String status, String items) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.status = status;
		this.items = items;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date date;
	@NotBlank
	private String status;
	@NotBlank
	private String items;
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}

}
