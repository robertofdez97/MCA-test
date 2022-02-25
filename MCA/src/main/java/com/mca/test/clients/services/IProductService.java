package com.mca.test.clients.services;

import java.util.List;

import com.mca.test.api.DTO.ProductDetail;

public interface IProductService {

	List<ProductDetail> getSimilarProduct(Integer id);

}
