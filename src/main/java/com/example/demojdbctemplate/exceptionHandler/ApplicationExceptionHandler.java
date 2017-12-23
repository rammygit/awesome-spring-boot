package com.example.demojdbctemplate.exceptionHandler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author ramkumar
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Generic Exception handler.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            Exception ex) {
        return buildResponseEntity(new ServiceError(HttpStatus.INTERNAL_SERVER_ERROR, ex));
    }

    /**
     * build Spring's ResponseEntity for response on Error.
     *
     * @param serviceError
     * @return
     */
    private ResponseEntity<Object> buildResponseEntity(ServiceError serviceError) {

        return new ResponseEntity<>(serviceError, serviceError.getStatus());

    }
}
