package com.mca.test.clients.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mca.test.api.DTO.ProductDetail;
import com.mca.test.clients.ExistingApiClient;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	@Mock
	ExistingApiClient apiClient;

	@InjectMocks
	ProductService productService;

	@Test
	void getSimilarProduct_OK() {
		Integer numElements = 3;
		when(apiClient.getSimilarProductsIds(Mockito.anyInt())).thenReturn(Lists.newArrayList(1, 2, 3));
		when(apiClient.getProductDetail(Mockito.anyInt())).thenReturn(Mockito.any(ProductDetail.class));

		List<ProductDetail> products = productService.getSimilarProduct(1);

		verify(apiClient, times(numElements)).getProductDetail(Mockito.anyInt());
		verify(apiClient, times(1)).getSimilarProductsIds(Mockito.anyInt());
		assertEquals(products.size(), numElements);

	}

}
