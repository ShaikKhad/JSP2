package com.jsp.Springboot_Crud_JSP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService ps;
	@GetMapping
	public String listProducts(@RequestParam(value="page",defaultValue = "0")int page,@RequestParam(value = "size",defaultValue = "5")int size, Model model) {
	Pageable pageable= PageRequest.of(page, size);
	Page<Product> productPage= ps.findall(pageable);
	 model.addAttribute("products", productPage.getContent());
	model.addAttribute("currentPage", page);
	model.addAttribute("totalPages",productPage.getTotalPages());
	return "product/list";
		
	}
@GetMapping("/create")
public String createProductForm(Model model){
	model.addAttribute("product",new Product());
	    return "product/form";
}
@PostMapping("/save")
public String saveProduct(@ModelAttribute Product p) {
	ps.save(p);
	return "redirect:/products";
}
@GetMapping("/edit/{id}")
public String editProductForm(@PathVariable Long id, Model model) {
	Product p= ps.findBYID(id);
	model.addAttribute("product",p);
	return "product/form";
	
}
@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
	ps.deleteById(id);
	return "redirect:/products";
}
}
