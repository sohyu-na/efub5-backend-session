package com.practice.blog.post.service;

import com.practice.blog.account.entity.Account;
import com.practice.blog.account.service.AccountService;
import com.practice.blog.post.domain.Post;
import com.practice.blog.post.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Test
    void PostService_생성_성공(@Mock AccountService accountService,@Mock PostRepository postRepository){
        Account account = new Account("efub@example.com","password","efub");
        account.setAccountId(1L);

        when(accountService.findByAccountId(1L)).thenReturn(account);

        PostService postService = new PostService(postRepository, accountService);

        Account findAccount = accountService.findByAccountId(1L);

        assertNotNull(postService);
    }

    @Test
    void createPost_작성자조회성공_정상생성(@Mock AccountService accountService,@Mock PostRepository postRepository){
        // given
        Account account = new Account("efub@example.com","password","efub");
        account.setAccountId(1L);

        when(accountService.findByAccountId(1L)).thenReturn(account);

        // when
        Account found = accountService.findByAccountId(1L);

        // then
        assertEquals(1L, found.getAccountId());
    }

    @Test
    void deletePost_중_postRepository_delete에서_예외_doThrow(@Mock AccountService accountService,@Mock PostRepository postRepository){
        // given
        Account account = new Account("efub@example.com","testpw","efub");
        account.setAccountId(1L);

        Post post = new Post("제목","내용",account);
        post.setId(10L);

        when(postRepository.findById(10L)).thenReturn(Optional.of(post));
        when(accountService.findByAccountId(1L)).thenReturn(account);

        // doThrow : void 메서드 delete(..)가 호출되면 예외 발생
        doThrow(new IllegalArgumentException("삭제 실패"))
                .when(postRepository).delete(any(Post.class));

        PostService postService = new PostService(postRepository, accountService);

        // then
        assertThrows(IllegalArgumentException.class,
                ()->postService.deletePost(10L,1L,"testpw"));
    }
    @Test
    void findByAccountId_2번째호출_RuntimeException(){
        // given
        Account a1 = new Account("efub@example.com","testpw1","efub1");
    }
}