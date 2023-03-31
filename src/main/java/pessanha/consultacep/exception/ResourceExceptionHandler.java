package pessanha.consultacep.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest request) {

        StandardError err = new StandardError(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
