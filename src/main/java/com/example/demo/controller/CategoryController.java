package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> products = categoryRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") ObjectId id) {
        Category category=   categoryRepository.findBy_id(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable ObjectId id) {
        categoryRepository.delete(categoryRepository.findBy_id(id));
        return new ResponseEntity<Category>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable ObjectId id, @RequestBody Category category) {
        category.set_id(id);
        categoryRepository.save(category);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }
}
