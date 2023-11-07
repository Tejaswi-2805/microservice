package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
public class CartDetailsApplication{

	public static void main(String[] args) {
		SpringApplication.run(CartDetailsApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
//	@Autowired
//	private CartRepository cartRepository;
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		Cart cart=new Cart();
//		
//		LineItem lineItem=new LineItem();
//		lineItem.setProductId("89");
//		lineItem.setProductName("Chair");
//		lineItem.setQuantity(5);
//		lineItem.setPrice(500);
//		
//		cart.getLineItems().add(lineItem);
//
//		this.cartRepository.save(cart);
//		
//	}

}
