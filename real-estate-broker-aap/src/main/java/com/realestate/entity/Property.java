package com.realestate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyId;
	private int propertyPrice;
	private String propertyType;
	private String propertyArea;
	private String propertyCity;
	private String propertyState;
}
