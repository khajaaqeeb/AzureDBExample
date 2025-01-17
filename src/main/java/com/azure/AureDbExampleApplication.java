package com.azure;

import com.azure.entity.Product;
import com.azure.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping
public class AureDbExampleApplication {

	@Autowired
	ProductRepo productRepo;

	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product){
		 Product p=productRepo.save(product);
		return  p;
	}
	@GetMapping("/productList")
	public List<Product> getAllProduct()
	{
		List<Product> product = productRepo.findAll();
		System.out.println(product);
		return productRepo.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(AureDbExampleApplication.class, args);
	}

}
