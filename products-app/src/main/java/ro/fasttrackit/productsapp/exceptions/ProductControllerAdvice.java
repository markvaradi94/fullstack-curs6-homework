package ro.fasttrackit.productsapp.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ApiError(exception.getMessage());
    }
}

@Value
class ApiError {
    String message;
}
