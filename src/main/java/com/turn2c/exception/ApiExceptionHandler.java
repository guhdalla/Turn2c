package com.turn2c.exception;

import com.turn2c.domain.enums.ErrorMessageEnum;
import com.turn2c.dto.response.ResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import static com.turn2c.domain.enums.ErrorMessageEnum.ARGUMENT_NOT_VALID;
import static com.turn2c.domain.enums.ErrorMessageEnum.INTERNAL_SERVER_ERROR;
import static com.turn2c.domain.enums.ErrorMessageEnum.MESSAGE_NOT_READABLE;

@ControllerAdvice
@RestControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final HttpServletResponse response;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseDto<Void> handle(Exception e) {

        return ResponseDto.error(INTERNAL_SERVER_ERROR, e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseDto<Void> handle(HttpMessageNotReadableException e) {

        return ResponseDto.error(MESSAGE_NOT_READABLE, e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto<Void> handle(MethodArgumentNotValidException e) {

        return ResponseDto.error(ARGUMENT_NOT_VALID, e);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseDto<Void> handle(ServiceException e) {

        response.setStatus(e.getHttpStatus().value());
        return ResponseDto.error(e.getError(), e);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseDto<Void> handle(AccessDeniedException e) {

        return ResponseDto.error(ErrorMessageEnum.ACCESS_DENIED, e);
    }
}
