package com.example.fawryapi.discount.model;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "discounts")
@ToString
public class Discount {

	public Discount() {
	}

	public Discount(String discountType, String serviceName, double discountPercentage,boolean active) {
		this.discountType = discountType;
		this.serviceName = serviceName;
		this.discountPercentage = discountPercentage;
		this.active = active;
	}

	@Id
	@SequenceGenerator(
			name = "discount_sequence",
			sequenceName = "discount_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "discount_sequence"
	)


	private Long discountId;
	private String discountType;
	private String serviceName = " ";
	private double discountPercentage;
	private boolean active;
	
	public Discount(String discountType, double discountPrecentage) {
		this.discountType = discountType;
		this.discountPercentage = discountPrecentage;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
