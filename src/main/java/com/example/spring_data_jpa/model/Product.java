package com.example.spring_data_jpa.model;

	import lombok.Data;
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

	@Data
	@Document(collection = "products")
	public class Product {
		@Id
	    @JsonProperty("productId")
	    private String productId;
	    
	    @JsonProperty("name")
	    private String name;
	    
	    @JsonProperty("price")
	    private int price;
	    
	    @JsonProperty("category")
	    private String category;
	    
	}
