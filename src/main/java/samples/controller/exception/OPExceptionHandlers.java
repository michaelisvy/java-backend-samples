package samples.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OPExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { BoomException.class })
    protected ResponseEntity<Object> handleBoomException(BoomException exception, WebRequest request) {
        String bodyOfResponse = "{\"message\":\""+ "BoomException: "+ exception.getMessage() + "\"}";
        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @ExceptionHandler(value = { ResponseStatusException.class })
    protected ResponseEntity<Object> handleResponseStatusException(ResponseStatusException exception, WebRequest request) {
        String bodyOfResponse = "{\"message\":\""+ "ResponseStatusException: "+  exception.getReason() + "\"}";
        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), exception.getStatus(), request);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handlePlainException(Exception exception, WebRequest request) {
        String bodyOfResponse = "{\"message\":\""+ "Exception: " + exception.getMessage() + "\"}";
        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
