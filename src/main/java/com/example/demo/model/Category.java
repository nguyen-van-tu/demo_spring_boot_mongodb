package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "category")

public class Category {
    private ObjectId _id;
    private String nameCategory;

}
