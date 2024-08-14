package com.example.lab11.Repository;

import com.example.lab11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select com from Comment com where com.comment_id=?1")
    Comment findCommentByComment_id(Integer id);
    @Query("select comment from Comment comment where comment.user_id=?1")
    List<Comment> getAllCommentsByUser_id(Integer id);

}
