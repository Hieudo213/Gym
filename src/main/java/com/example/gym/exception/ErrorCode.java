package com.example.gym.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(500, "Đã xảy ra lỗi trên máy chủ. Vui lòng thử lại sau.", HttpStatus.INTERNAL_SERVER_ERROR),
    LIST_EMPTY(404, "Danh sách rỗng", HttpStatus.BAD_REQUEST),
    USER_EXISTED(409, "Người dùng đã tồn tại ", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(404, "Không tìm thấy người dùng.", HttpStatus.NOT_FOUND),
    ITEM_NOT_FOUND(404, "Không tìm thấy.", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(401, "Chưa xác thực.", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(403, "Chưa cấp quyền", HttpStatus.FORBIDDEN),
    ;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;
}
