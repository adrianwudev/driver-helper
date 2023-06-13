package adrianwudev.driverhelper.Exception;

import adrianwudev.driverhelper.Codes.StatusCode;
import adrianwudev.driverhelper.Response.JsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonResponse<Object>> handleException(Exception ex) {
        log.error("Exception occurred: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new JsonResponse<>(StatusCode.INTERNAL_ERROR.getCode()));
    }
}
