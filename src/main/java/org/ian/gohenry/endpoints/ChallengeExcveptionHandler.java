package org.ian.gohenry.endpoints;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * exception handler to handle all uncaught exceptions
 * and any run time exceptions that may occur.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ChallengeExcveptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handleThrowable (Throwable t) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntime (RuntimeException t) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgument (IllegalArgumentException t) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
