package  com.security.HotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        Map<String,Object> map = new HashMap<>();
        map.put("message",exception.getMessage());
        map.put("success",false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
