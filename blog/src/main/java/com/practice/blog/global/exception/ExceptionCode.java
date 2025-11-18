package com.practice.blog.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {
    // 400 Bad Request
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, ClientExceptionCode.INVALID_PARAMETER, "잘못된 인자입니다."),
    POST_CONTENT_INVALID_LENGTH(HttpStatus.BAD_REQUEST, ClientExceptionCode.POST_CONTENT_INVALID_LENGTH, "포스트 내용은 5자 이상 500자 이하여야 합니다."),

    // 401 Unauthorized
    POST_ACCOUNT_MISMATCH(HttpStatus.UNAUTHORIZED, ClientExceptionCode.POST_ACCOUNT_MISMATCH, "허용되지 않은 계정의 접근입니다."),
    COMMENT_ACCOUNT_MISMATCH(HttpStatus.UNAUTHORIZED, ClientExceptionCode.COMMENT_ACCOUNT_MISMATCH, "허용되지 않은 계정의 접근입니다."),

    // 404 Not Found
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.ACCOUNT_NOT_FOUND, "계정이 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.POST_NOT_FOUND, "포스트가 존재하지 않습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.COMMENT_NOT_FOUND, "댓글이 존재하지 않습니다."),
    LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.LIKE_NOT_FOUND, "댓글 좋아요가 존재하지 않습니다."),
    FOLLOW_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.FOLLOW_NOT_FOUND, "팔로우 관계가 존재하지 않습니다."),

    // 409 Conflict
    LIKE_ALREADY_EXISTS(HttpStatus.CONFLICT, ClientExceptionCode.LIKE_ALREADY_EXISTS, "이미 좋아요를 누르셨습니다."),
    ALREADY_FOLLOWED(HttpStatus.CONFLICT, ClientExceptionCode.ALREADY_FOLLOWED, "이미 팔로우한 사용자입니다."),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ClientExceptionCode.INTERNAL_SERVER_ERROR, "예상치 못한 서버에러가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final ClientExceptionCode clientExceptionCode;
    private final String message;

    ExceptionCode(HttpStatus httpStatus, ClientExceptionCode clientExceptionCode, String message) {
        this.httpStatus = httpStatus;
        this.clientExceptionCode = clientExceptionCode;
        this.message = message;
    }
}
