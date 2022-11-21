package com.java.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.java.app.beans.Product;


@RestController
@EnableWebMvc
@RequestMapping("/product")
public class ProductController
{
	private List<Product> prodList=new ArrayList<Product>();
	static
	{
		System.out.println("Product Controller loaded.....");
	}
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String Save()
	{
		return "Hello";	
	}
	
	@GetMapping("/list")
	public List<Product> getListOfProducts()
	{
		List<Product> prodList=new ArrayList<Product>();
		prodList.add(new Product(101,"Mobile",10,25522.23,"Flipcart"));
		prodList.add(new Product(102,"TV",20,61522.23,"Flipkart"));
		return prodList;
		
	}
	
	@PostMapping
	public String SearchProduct()
	{
		return null;
		
	}

	@DeleteMapping
	public String deleteProduct()
	{
		return null;
		
	}
	
	@PutMapping
	public String updateProduct()
	{
		return null;
		
	}
}
