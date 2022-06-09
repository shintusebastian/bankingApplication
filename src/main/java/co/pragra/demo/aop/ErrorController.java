package co.pragra.demo.aop;

import co.pragra.demo.entity.ErrorResponse;
import co.pragra.demo.exceptions.AccountNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice //now, spring mvc will register this as AOP advice and execute it whenever it sees such exceptions.
public class ErrorController {
    @ExceptionHandler({AccountNotFoundException.class})
    //we are saying that the exception we are handling here is the
    //account not found exception.
    public ResponseEntity<?> handleNotFound(Exception ex, HttpServletRequest request) {
        System.out.println(request.getHeader("X-REQUESTER"));

        //we can get other information from the request by putting a dot operator on request.
        return ResponseEntity.status(404).header("X-Fault", "NO DATA")
                .body(ErrorResponse.builder().code(10001).message(ex.getMessage()).applicationId("DL1")
                        .time(Instant.now()).build());
    }

    @ExceptionHandler({IllegalArgumentException.class, Exception.class})
//we say that the exception we are handling includes illegal arguments and other exceptions.
    public ResponseEntity<?> handleInvalidID(Exception ex) {
        return ResponseEntity.status(400).header("X-Fault", "NO DATA")
                .body(ErrorResponse.builder().code(10002).message(ex.getMessage()).applicationId("DL1")
                        .time(Instant.now()).build());
    }

}
