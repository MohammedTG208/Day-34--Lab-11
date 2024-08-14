package com.example.lab11.Controller;

import com.example.lab11.Model.Comment;
import com.example.lab11.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/getall")
    public ResponseEntity getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }
    @GetMapping("/get/by/{id}")
    public ResponseEntity getCommentById(@PathVariable Integer id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
    @GetMapping("/get/by/userid/{user_id}")//5
    public ResponseEntity getCommentByUserId(@PathVariable Integer user_id) {
        return ResponseEntity.status(200).body(commentService.getAllByUserId(user_id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCommentById(@PathVariable Integer id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.status(200).body("delete comment success");
    }
    @PostMapping("/add")
    public ResponseEntity addComment(@Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            commentService.addNewComment(comment);
            return ResponseEntity.status(201).body("comment add success");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@Valid @RequestBody Comment comment, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }else {
            commentService.updateCommentById(id, comment);
            return ResponseEntity.status(201).body("comment update success");
        }
    }
}
