package com.example.lab11.Controller;

import com.example.lab11.Model.Post;
import com.example.lab11.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/getall")
    public ResponseEntity getAllPost(){
        return ResponseEntity.ok(postService.getAllPosts());
    }
    @GetMapping("/get/by/id/{id}")
    public ResponseEntity getPostById(@PathVariable Integer id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @GetMapping("/get/by/date/{date}")//6
    public ResponseEntity getPostByDate(@PathVariable String date){
        return ResponseEntity.ok(postService.getPostByDate(date));
    }
    @GetMapping("/get/by/title/{title}")//7
    public ResponseEntity getAllPostByTitle(@PathVariable String title){
        return ResponseEntity.ok(postService.getPostByTitle(title));
    }
    @GetMapping("/get/by/cat/{catid}")//8
    public ResponseEntity getPostByCat(@PathVariable int catid){
        return ResponseEntity.status(200).body(postService.getPostByCategory(catid));
    }
    @PostMapping("/add")
    public ResponseEntity addNewPost(@Valid @RequestBody Post post, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            postService.addNewPost(post);
            return ResponseEntity.status(201).body("post added successfully");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePostById(id);
        return ResponseEntity.status(200).body("post deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @Valid @RequestBody Post post,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            postService.updatePost(post,id);
            return ResponseEntity.status(201).body("post updated successfully");
        }
    }


}
