package com.example.lab11.Service;

import com.example.lab11.Api.APiException;
import com.example.lab11.Model.Comment;
import com.example.lab11.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    public Comment getCommentById(Integer id) {
        if (commentRepository.findCommentByComment_id(id)==null){
            throw new APiException("DB is Empty");
        }
        return commentRepository.findCommentByComment_id(id);
    }

    public List<Comment> getAllComments() {
        if (commentRepository.findAll().isEmpty()){
            throw new APiException("DB is Empty");
        }
        return commentRepository.findAll();
    }

    public void addNewComment(Comment comment) {
        if (userService.getUserById(comment.getUser_id())==null){
            throw new APiException("User id not found before");
        }else {
            if (postService.getPostById(comment.getPost_id())==null){
                throw new APiException("Post id not found before");
            }else {
                commentRepository.save(comment);
            }
        }

    }

    public void deleteCommentById(Integer id) {
        if (commentRepository.findCommentByComment_id(id)==null){
            throw new APiException("the comment is not found");
        }
        commentRepository.delete(commentRepository.findCommentByComment_id(id));
    }

    public void updateCommentById(Integer id, Comment comment) {
        if (commentRepository.findCommentByComment_id(id) == null) {
            throw new APiException("the comment is not found");
        } else {
            if (userService.getUserById(comment.getUser_id()) == null) {
                throw new APiException("User id not found before");
            } else {
                if (postService.getPostById(comment.getPost_id()) == null) {
                    throw new APiException("Post id not found before");
                } else {
                    Comment oldComment = commentRepository.findCommentByComment_id(id);
                    oldComment.setContent(comment.getContent());
                    oldComment.setPost_id(comment.getPost_id());
                    oldComment.setUser_id(comment.getUser_id());
                    commentRepository.save(oldComment);
                }
            }
        }
    }
    public List<Comment> getAllByUserId(Integer user_id) {
        if (commentRepository.getAllCommentsByUser_id(user_id).isEmpty()){
            throw new APiException("DB is Empty");
        }
        return commentRepository.getAllCommentsByUser_id(user_id);
    }
}
