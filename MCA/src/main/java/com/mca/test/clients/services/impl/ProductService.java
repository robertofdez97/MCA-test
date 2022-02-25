package com.mca.test.clients.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mca.test.api.DTO.ProductDetail;
import com.mca.test.clients.ExistingApiClient;
import com.mca.test.clients.services.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	ExistingApiClient existingApiClient;

	@Override
	public List<ProductDetail> getSimilarProduct(Integer id) {
		List<Integer> similarIds = existingApiClient.getSimilarProductsIds(id);
		return similarIds.parallelStream().map(productId -> existingApiClient.getProductDetail(productId)
		).collect(Collectors.toList());
	}
	
}
