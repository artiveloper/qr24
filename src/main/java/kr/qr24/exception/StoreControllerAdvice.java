package kr.qr24.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StoreControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = StoreNotFound.class)
    public String handleStoreNotFound() {
        return "errors/404";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = CategoryNotFound.class)
    public String handleCategoryNotFound() {
        return "errors/404";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UserNotFound.class)
    public String handleUserNotFound() {
        return "errors/404";
    }

}
