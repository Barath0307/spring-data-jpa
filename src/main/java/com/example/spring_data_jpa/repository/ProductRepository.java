package com.example.spring_data_jpa.repository;

	import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_data_jpa.model.Product;
@Repository
	public interface ProductRepository extends MongoRepository<Product, String> {
	}

