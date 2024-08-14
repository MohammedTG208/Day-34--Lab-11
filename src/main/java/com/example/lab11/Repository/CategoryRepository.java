package com.example.lab11.Repository;

import com.example.lab11.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select cat from Category cat where cat.category_id=?1")
    Category getCategoryByCategory_id(Integer id);

    Category findCategoryByName(String name);
}
