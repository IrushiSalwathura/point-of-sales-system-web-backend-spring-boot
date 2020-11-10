package lk.ijse.dep.api.advice;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /*@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String globalExceptionHandlerMethod(){
        return "Contact the dev team";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    public String globalResponseStatusExceptionHandlerMethod(){
        return "Wrong INFO";
    }*/
}
