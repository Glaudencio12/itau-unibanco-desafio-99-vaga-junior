package desafio_vaga_99_junior.exception.handler;
import desafio_vaga_99_junior.config.TimestampFormat;
import desafio_vaga_99_junior.exception.BadRequestException;
import desafio_vaga_99_junior.exception.ExceptionResponse;
import desafio_vaga_99_junior.exception.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), TimestampFormat.timestampFormat(), request.getDescription(true));
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handlerBadRequestException(Exception exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), TimestampFormat.timestampFormat(), request.getDescription(true));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ExceptionResponse> handlerUnprocessableEntityException(Exception exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(), TimestampFormat.timestampFormat(), request.getDescription(true));
        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
