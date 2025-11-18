package com.practice.blog.comment.dto.request;

import com.practice.blog.account.entity.Account;
import com.practice.blog.comment.domain.Comment;
import com.practice.blog.post.domain.Post;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequest {
    private Long accountId;
    private String content;

    public Comment toEntity(Account account, Post post) {
        return Comment.builder()
                .content(content)
                .writer(account)
                .post(post)
                .build();
    }
}
