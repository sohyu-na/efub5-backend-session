package com.practice.blog.global.exception;

public enum ClientExceptionCode {
    // 전체
    INTERNAL_SERVER_ERROR,
    INVALID_PARAMETER,

    // Account
    ACCOUNT_NOT_FOUND,

    // Post
    POST_NOT_FOUND,
    POST_CONTENT_INVALID_LENGTH,
    POST_ACCOUNT_MISMATCH,

    // Comment
    COMMENT_NOT_FOUND,
    COMMENT_ACCOUNT_MISMATCH,

    // CommentLike
    LIKE_NOT_FOUND,
    LIKE_ALREADY_EXISTS,

    // Follow
    ALREADY_FOLLOWED,
    FOLLOW_NOT_FOUND

}
