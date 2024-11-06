package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.exception.DatabaseException;
import com.example.spring_data_jpa.model.Product;
import com.example.spring_data_jpa.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showForm(Model model) {
    	System.out.println("model");
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
        	System.out.println("Hello " + product.toString());
            Product savedProduct = productService.saveProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (DatabaseException e) {
            return ResponseEntity.internalServerError()
                .body("Error saving product: " + e.getMessage());
        }
    }

    @GetMapping("/displayAll")
    @ResponseBody
    public ResponseEntity<?> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (DatabaseException e) {
            return ResponseEntity.internalServerError()
                .body("Error fetching products: " + e.getMessage());
        }
    }

    @GetMapping("/display/{productId}")
    @ResponseBody
    public ResponseEntity<?> getProduct(@PathVariable String productId) {
        try {
            return productService.getProductById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        } catch (DatabaseException e) {
            return ResponseEntity.internalServerError()
                .body("Error fetching product: " + e.getMessage());
        }
    }
}
