package com.example.lab11.Controller;

import com.example.lab11.Model.Category;
import com.example.lab11.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/getall")
    public ResponseEntity getAllCategory() {
        return ResponseEntity.status(200).body(categoryService.findAllCat());
    }

    @GetMapping("/get/by/{id}")//4
    public ResponseEntity getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(categoryService.findCatById(id));
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            categoryService.addNewCat(category);
            return ResponseEntity.status(201).body("category added successfully");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCatById(id);
        return ResponseEntity.status(200).body("category deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            categoryService.updateCat(category, id);
            return ResponseEntity.status(201).body("category updated successfully");
        }
    }
}
