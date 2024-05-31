package rest.Rest_Beginning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Generic_Exception extends RuntimeException{

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e){
        e.printStackTrace();
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
