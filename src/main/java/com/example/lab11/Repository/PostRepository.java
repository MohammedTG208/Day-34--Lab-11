package com.example.lab11.Repository;

import com.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostById(Integer id);

    @Query("select post from Post post where post.postdate==?1")
    List<Post> getPostByDateE(String date);

    List<Post> findPostByTitle(String title);

    List<Post> findPostByCategoryid(int categoryid);
}
