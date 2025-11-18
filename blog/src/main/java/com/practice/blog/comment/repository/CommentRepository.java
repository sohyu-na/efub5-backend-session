package com.practice.blog.comment.repository;

import com.practice.blog.comment.domain.Comment;
import com.practice.blog.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostIdOrderByCreatedAt(Long postId);
    List<Comment> findAllByWriterAccountIdOrderByCreatedAtDesc(Long accountId);}
