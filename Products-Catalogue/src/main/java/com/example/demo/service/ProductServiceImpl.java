package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repo;

	@Override
	public Product addProduct(Product productList) {
		return repo.save(productList);
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product p1=repo.findById(productId).get();
		p1.setproductName(product.getproductName());
		p1.setProductDescription(product.getProductDescription());
		p1.setProductPrice(product.getProductPrice());
		repo.save(p1);
		return p1;
	}


	@Override
	public Optional<Product> searchProduct(int productId) {
		Optional<Product> product=repo.findById(productId);
		return product;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		if(repo.existsById(productId)) {
			repo.deleteById(productId);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products=repo.findAll();
		return products;
	}

}
