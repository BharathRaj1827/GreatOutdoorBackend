package com.capgemini.gos;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.capgemini.gos.entity.GrowthReport;
import com.capgemini.gos.entity.RevenueTable;
import com.capgemini.gos.dao.ProductRepository;
import com.capgemini.gos.entity.Product;
import com.capgemini.gos.exceptions.ProductNotFoundException;
import com.capgemini.gos.service.ProductService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class productmanagementsystemApplicationTests {
	@Autowired
	private ProductService service;
	@MockBean
	private ProductRepository repository;
	@Test
	public void deleteProducttest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
	repository.deleteById("12");
	    verify(repository,times(1)).deleteById("12");
	}
	@Test
	public void negativedeleteProducttest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
	repository.deleteById("5");
	assertFalse(product.getId()=="5");
	}
	@Test
	public void updateProducttest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		repository.save(product);
	    verify(repository,times(1)).save(product);
		
	}
	@Test
	public void negativeupdateProducttest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		repository.save(product);
		assertFalse(product.getId()=="11");
	}
	@Test
	public void getallProductsTest() throws ProductNotFoundException {
		when(repository.findAll()).thenReturn(Stream.of(new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7),
		new Product("15",190.9,"green","30metres","sweet","large",10,"consumer","chocolates",10)).collect(Collectors.toList()));
		assertEquals(2,service.getAll().size());
		
	}
	@Test
	
	public void  addtest() {
	Product product=new Product();
	product.setId("19");
	product.setPrice(100.00);
	product.setColour("Orange");
	product.setDimensions("10metres");
	product.setSpecifications("nicestorage");
	product.setManufacture("small");
	product.setQuantity(40);
	product.setProductCategory("consumer");
	product.setProductName("phone");
	product.setRetailerId(12);
	 repository.save(product);
	 Mockito.verify(repository, Mockito.times(1)).save(product); 
	}
	@Test
	
	public void  negativeaddtest() {
	Product product=new Product();
	product.setId("19");
	product.setPrice(100.00);
	product.setColour("Orange");
	product.setDimensions("10metres");
	product.setSpecifications("nicestorage");
	product.setManufacture("small");
	product.setQuantity(40);
	product.setProductCategory("consumer");
	product.setProductName("phone");
	product.setRetailerId(15);
	 repository.save(product);
	 assertFalse(product.getId()=="11");
	}
	@Test
	public void getProductByIdTest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		assertEquals("12",product.getId());
	}
	@Test
	public void negativegetProductByIdTest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		assertFalse(product.getId()=="10");
	}
	@Test
	public void searchProductByProductNameTest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		assertEquals("chocolates",product.getProductName());
	}
	@Test
	public void negativesearchProductByProductNameTest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		assertFalse(product.getProductName()=="Biscuits");
	}
	@Test
	public void searchProductByProductCatogeryTest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		assertEquals("consumer",product.getProductCategory());
	}
	@Test
	public void negativesearchProductByProductCatogeryTest() {
		Product product =new Product("12",120.9,"pink","30metres","sweet","small",19,"consumer","chocolates",7);
		assertFalse(product.getProductCategory()=="producer");
	}
	

	@Test
	public void revenueData() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + 8885 + "/Reports/GrowthReport/2020-01-01/2020-12-31/mountaineering";
		URI uri = new URI(baseUrl);

		ResponseEntity<GrowthReport[]> datalist = restTemplate.getForEntity(uri, GrowthReport[].class);
		GrowthReport[] data = datalist.getBody();
		assertNotEquals(2, data.length);
}
	
	@Test
	public void salesData() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
	    
	    final String baseUrl = "http://localhost:" + 8885 + "/Reports/SalesReport/2018-01-01/2020-04-01/qaz12/campingequipment" ;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<RevenueTable[]> datalist = restTemplate.getForEntity(uri, RevenueTable[].class);
	    RevenueTable[] data = datalist.getBody();
	    assertNotEquals(2, data.length);


	}

}
