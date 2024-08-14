package com.example.lab11.Service;

import com.example.lab11.Api.APiException;
import com.example.lab11.Model.Post;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public List<Post> getAllPosts(){
        if (postRepository.findAll().isEmpty()) {
            throw new APiException("No posts found");
        }else {
            return postRepository.findAll();
        }
    }
    public Post getPostById(Integer id){
        if (postRepository.findPostById(id)==null){
            throw new APiException("Post not found");
        }
        return postRepository.findPostById(id);
    }
    public void addNewPost(Post post){
        if (userService.getUserById(post.getUser_id())==null){
            throw new APiException(" the User id not added before");
        }else {
            if (categoryService.findCatById(post.getCategoryid()) == null) {
                throw new APiException(" the Category id not added before");
            } else {
                postRepository.save(post);
            }
        }
    }
    public void deletePostById(Integer id){
        if (postRepository.findPostById(id)==null){
            throw new APiException("Post not found");
        }
        postRepository.deleteById(id);
    }
    public void updatePost(Post post,Integer id) {
        if (postRepository.findPostById(id) == null) {
            throw new APiException("Post not found");
        } else {
            if (userService.getUserById(post.getUser_id()) == null) {
                throw new APiException(" the User id not added before");
            } else {
                if (categoryService.findCatById(post.getCategoryid()) == null) {
                    throw new APiException(" the Category id not added before");
                } else {
                    postRepository.save(post);
                }
            }
        }
    }
    //8
    public List<Post> getPostByTitle(String title){
        if (postRepository.findPostByTitle(title)==null){
            throw new APiException("Post not found");
        }
        return postRepository.findPostByTitle(title);
    }
    //7
    public List<Post> getPostByDate(String date){
        if (postRepository.getPostByDateE(date)==null){
            throw new APiException("Post not found");
        }
        return postRepository.getPostByDateE(date);
    }
    //6
    public List<Post> getPostByCategory(int categoryId){
        if (postRepository.findPostByCategoryid(categoryId)==null){
            throw new APiException("Post not found");
        }
        return postRepository.findPostByCategoryid(categoryId);
    }
}
