package com.example.demojdbctemplate.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author ramkumar
 * <p>
 * for return error for API responses.
 */


public class ServiceError {

    //high level status.
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    //validation errors, security errors.
    private List<String> errors;


    public ServiceError() {
        super();
        timestamp = LocalDateTime.now();
    }

    public ServiceError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ServiceError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Some unexpected error happened.";
        this.debugMessage = ex.getLocalizedMessage();
    }


    public ServiceError(HttpStatus status, @NotNull Throwable ex, String message) {
        this(status, ex);
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    public void setError(final String error) {
        errors = Arrays.asList(error);
    }


}
