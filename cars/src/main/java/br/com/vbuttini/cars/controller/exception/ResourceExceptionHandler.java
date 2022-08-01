package br.com.vbuttini.cars.controller.exception;

import br.com.vbuttini.cars.factory.LocalDateTimeFactory;
import br.com.vbuttini.cars.service.exception.DataBaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.format.DateTimeFormatter;

/**
 * @author Vinícius Buttini
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request){
        var error = "DataBaseError";
        var status = HttpStatus.CONFLICT;
        var err = StandardError.builder()
                .timestamp(LocalDateTimeFactory.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .status(status.value())
                .error(error)
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(err);
    }

}
