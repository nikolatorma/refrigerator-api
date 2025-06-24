package com.refrigerator.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fridge_item")
public class FridgeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Integer quantity;
    private LocalDate dateStored;
    private LocalDate bestBeforeDate;
	private Long userId;
    private Long goodId;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public LocalDate getDateStored() {
		return dateStored;
	}
	public void setDateStored(LocalDate dateStored) {
		this.dateStored = dateStored;
	}
	public LocalDate getBestBeforeDate() {
		return bestBeforeDate;
	}
	public void setBestBeforeDate(LocalDate bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGoodId() {
		return goodId;
	}
	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}
}
