package com.mca.test.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mca.test.api.DTO.ProductDetail;
import com.mca.test.clients.services.IProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@GetMapping("/{productId}/similar")
	public List<ProductDetail> getSimilarProduct(@PathVariable(name = "productId", required = true) Integer productId) {
		return productService.getSimilarProduct(productId);
	}
	
	
}
