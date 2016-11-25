package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Product;
import boot.service.ProductService;


@Controller
public class ProductController {
  
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/all-products")
	public String allProducts(HttpServletRequest request){
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "product";
	}
	
	@GetMapping("/new-product")
	public String newProduct(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_PRODUCT");
		return "product";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult, HttpServletRequest request){
		productService.saveProduct(product);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "product";
	}
	
	@GetMapping("/update-product")
	public String updateProduct(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("product", productService.findProduct(id));
		request.setAttribute("mode", "MODE_UPDATE_PRODUCT");
		return "product";
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam int id, HttpServletRequest request){
		productService.deleteProduct(id);
		request.setAttribute("products", productService.findAll());
		request.setAttribute("mode", "MODE_PRODUCTS");
		return "product";
	}
		
 }
