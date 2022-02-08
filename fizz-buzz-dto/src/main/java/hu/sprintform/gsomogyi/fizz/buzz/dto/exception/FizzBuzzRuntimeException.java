package hu.sprintform.gsomogyi.fizz.buzz.dto.exception;

import lombok.Getter;

@Getter
public class FizzBuzzRuntimeException extends RuntimeException {

    private final ErrorCode errorCode;

    public FizzBuzzRuntimeException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public FizzBuzzRuntimeException(ErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public FizzBuzzRuntimeException(String message, Exception e) {
        super(message, e);
        this.errorCode = null;
    }
}
