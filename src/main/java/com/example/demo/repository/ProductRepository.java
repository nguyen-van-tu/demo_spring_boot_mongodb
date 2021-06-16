package com.example.demo.repository;

import com.example.demo.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface ProductRepository extends MongoRepository<Product,Long> {
        Product findBy_id(ObjectId _id);

    }
