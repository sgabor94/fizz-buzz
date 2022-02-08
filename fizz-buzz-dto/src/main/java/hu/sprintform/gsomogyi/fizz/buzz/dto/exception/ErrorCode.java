package hu.sprintform.gsomogyi.fizz.buzz.dto.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    INVALID_VALUE_FOR_NUMBER(HttpStatus.INTERNAL_SERVER_ERROR, "Number must be greater than 0"),
    INVALID_ZERO_DIVIDER(HttpStatus.INTERNAL_SERVER_ERROR, "Cannot be zero divider");

    private final HttpStatus httpStatus;
    private final String description;

    ErrorCode(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
