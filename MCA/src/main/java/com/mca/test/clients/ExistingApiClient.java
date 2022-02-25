package com.mca.test.clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mca.test.api.DTO.ProductDetail;
import com.mca.test.config.ExistingApi;

@Component
public class ExistingApiClient {
	
	@Autowired 
	RestTemplate restTemplate;
	
	@Autowired
	ExistingApi urls;
	
	public ProductDetail getProductDetail(Integer id) {
		return restTemplate.getForObject(urls.getGetProduct(), ProductDetail.class, id);
	}
	
	public List<Integer> getSimilarProductsIds(Integer id){
		return Arrays.asList(restTemplate.getForObject(urls.getGetSimilar(), Integer[].class, id));

	}
	
}
