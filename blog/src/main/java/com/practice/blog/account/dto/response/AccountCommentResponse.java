package com.practice.blog.account.dto.response;

import com.practice.blog.account.entity.Account;
import com.practice.blog.comment.domain.Comment;
import com.practice.blog.comment.dto.response.CommentResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountCommentResponse {
    private final String accountNickname;
    private final List<CommentResponse> accountCommentList;
    private final Long count;

    public static AccountCommentResponse of(Account account, List<Comment> commentList) {
        return AccountCommentResponse.builder()
                .accountNickname(account.getNickname())
                .accountCommentList(commentList.stream().map(CommentResponse::of).collect(Collectors.toList()))
                .count((long) commentList.size())
                .build();
    }
}
