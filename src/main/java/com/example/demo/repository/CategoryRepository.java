package com.example.demo.repository;

import com.example.demo.model.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Long> {
    Category findBy_id(ObjectId _id);

}
