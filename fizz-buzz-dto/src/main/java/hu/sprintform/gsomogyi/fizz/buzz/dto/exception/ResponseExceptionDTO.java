package hu.sprintform.gsomogyi.fizz.buzz.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseExceptionDTO {

    private final String errorCode;
    private final String description;
    private final String message;
}
