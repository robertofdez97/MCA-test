package com.mca.test.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.mca.test.clients.services.IProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	@Mock
	IProductService productService;
	
	@InjectMocks
	ProductController productController;
	
	@Test
	void similarProductTest() {
		
		when(productService.getSimilarProduct(Mockito.anyInt())).thenReturn(Lists.newArrayList(Mockito.any(ProductDetail.class)));
		List<ProductDetail> similarProducts = productController.getSimilarProduct(1);
		assertEquals(similarProducts.size(), 1);
		
	}

}
