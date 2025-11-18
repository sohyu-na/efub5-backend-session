package com.practice.blog.post.dto.request;

import com.practice.blog.account.entity.Account;
import com.practice.blog.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostCreateRequest(@NotNull Long accountId,
                                @NotBlank(message = "제목을 입력해야 합니다.") String title,
                                @Size(min=5, max=500, message = "내용은 5자이상 500자이하로 입력해야합니다.") String content) {

    public Post toEntity(Account account) {
        return Post.builder()
                .title(title)
                .content(content)
                .writer(account)
                .build();
    }
}
