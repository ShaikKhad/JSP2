package com.jsp.Springboot_Crud_JSP;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long>{
	

}
