package com.springbootorderdetails.apiexample.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Item")
@EntityListeners(AuditingEntityListener.class)
public class Item {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemid;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Order")
	private Long orderid;
	
	public Item() {
		
	}
	
	public Item(Long itemid, Long orderid, String itemname, Long price, Long quntity) {
		super();
		this.itemid = itemid;
		this.orderid = orderid;
		this.itemname = itemname;
		this.price = price;
		this.quntity = quntity;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuntity() {
		return quntity;
	}
	public void setQuntity(Long quntity) {
		this.quntity = quntity;
	}
	@NotBlank
	private String itemname;
	@NotBlank
	private Long price;
	@NotBlank
	private Long quntity;

}
