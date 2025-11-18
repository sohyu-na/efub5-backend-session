package com.practice.blog.comment.repository;

import com.practice.blog.account.entity.Account;
import com.practice.blog.comment.domain.Comment;
import com.practice.blog.comment.domain.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

    boolean existsByCommentAndAccount(Comment comment, Account account);

    Optional<CommentLike> findByCommentAndAccount(Comment comment, Account account);
}
