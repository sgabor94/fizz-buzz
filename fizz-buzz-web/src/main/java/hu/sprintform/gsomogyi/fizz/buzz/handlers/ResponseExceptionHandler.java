package hu.sprintform.gsomogyi.fizz.buzz.handlers;

import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.FizzBuzzRuntimeException;
import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.ResponseExceptionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ResponseExceptionHandler {

    @ExceptionHandler(FizzBuzzRuntimeException.class)
    @ResponseBody
    public ResponseEntity<ResponseExceptionDTO> handleLimitRuntimeException(FizzBuzzRuntimeException e) {
        log.error("Handling error: " + e.getErrorCode().getDescription(), e);
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(new ResponseExceptionDTO(e.getErrorCode().name(), e.getErrorCode().getDescription(), ExceptionUtils.getRootCauseMessage(e)));
    }
}
