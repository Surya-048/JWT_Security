package rest.Rest_Beginning.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class UsernameNotFoundException extends RuntimeException{
    public void UsernameNotFoundException(){}

    public UsernameNotFoundException(String msg){
        super(msg);

    }
}
