package com.mca.test.api.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
	
	private String id = null;

	private String name = null;

	private BigDecimal price = null;

	private Boolean availability = null;
}