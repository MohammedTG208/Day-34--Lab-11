package com.example.lab11.Service;

import com.example.lab11.Api.APiException;
import com.example.lab11.Model.Category;
import com.example.lab11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAllCat(){
        if (categoryRepository.findAll().isEmpty()){
            throw new APiException("The DB is empty");
        }
        return categoryRepository.findAll();
    }
    public Category findCatById(Integer id){
        if (categoryRepository.getCategoryByCategory_id(id)==null){
            throw new APiException("The category does not exist");
        }
        return categoryRepository.getCategoryByCategory_id(id);
    }

    public void addNewCat(Category category){
        categoryRepository.save(category);
    }

    public void deleteCatById(Integer id){
        if (categoryRepository.getCategoryByCategory_id(id)==null){
            throw new APiException("The category does not exist");
        }
        categoryRepository.delete(categoryRepository.getCategoryByCategory_id(id));
    }

    public void updateCat(Category category, Integer id){
        if (categoryRepository.getCategoryByCategory_id(id)==null){
            throw new APiException("The category does not exist");
        }
        Category oldCat = categoryRepository.getCategoryByCategory_id(id);
        oldCat.setName(category.getName());
        categoryRepository.save(oldCat);
    }
}
