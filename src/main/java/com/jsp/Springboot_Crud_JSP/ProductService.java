package com.jsp.Springboot_Crud_JSP;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	public Page<Product>findall(org.springframework.data.domain.Pageable pageable){
		return productRepository.findAll(pageable);
		
	}
	public Product findBYID(Long id) {
		return productRepository.findById(id).orElse(null);
		
	}
	public Product save(Product product) {
		return productRepository.save(product);
		
	}
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	
}
