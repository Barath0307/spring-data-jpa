package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.exception.DatabaseException;
import com.example.spring_data_jpa.model.Product;
import com.example.spring_data_jpa.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.MongoException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (MongoException e) {
            throw new DatabaseException("Error saving product: " + e.getMessage(), e);
        }
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (MongoException e) {
            throw new DatabaseException("Error fetching products: " + e.getMessage(), e);
        }
    }

    public Optional<Product> getProductById(String productId) {
        try {
            return productRepository.findById(productId);
        } catch (MongoException e) {
            throw new DatabaseException("Error fetching product: " + e.getMessage(), e);
        }
    }
}