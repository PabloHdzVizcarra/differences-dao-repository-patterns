package jvm.pablohdz.daorepositorypatternexample.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    protected ResponseEntity<?> userNotFoundHandler(
            UserNotFoundException exception,
            WebRequest webRequest
    ) {
        return handleExceptionInternal(exception, exception.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest
        );
    }

    @ExceptionHandler(TweetDuplicateTextContent.class)
    protected ResponseEntity<?> tweetDuplicateContentHandler(
            TweetDuplicateTextContent ex,
            WebRequest request
    ) {
        return handleExceptionInternal(ex,
                "You dont can create a tweet, because the text content is duplicated in another " +
                        "tweet",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request
        );
    }
}
