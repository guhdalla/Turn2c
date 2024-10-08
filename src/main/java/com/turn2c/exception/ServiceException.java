package com.turn2c.exception;


import com.turn2c.domain.enums.ErrorMessageEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;


import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public class ServiceException extends RuntimeException {

    private final ErrorMessageEnum error;
    private final HttpStatus httpStatus;

    public ServiceException(ErrorMessageEnum error, Throwable cause, HttpStatus httpStatus) {
        super(cause);
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public ServiceException(ErrorMessageEnum error, Throwable cause) {
        super(cause);
        this.error = error;
        this.httpStatus = BAD_REQUEST;
    }

    public ServiceException(ErrorMessageEnum error, HttpStatus httpStatus) {
        super(error.getMessage());
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public ServiceException(ErrorMessageEnum error) {
        super(error.getMessage());
        this.error = error;
        this.httpStatus = BAD_REQUEST;
    }
}
