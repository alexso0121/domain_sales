package org.example.Exception;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
public class CustomException {
    private String message;
    private Throwable e;

    private HttpStatus httpStatus;

    private LocalDateTime time;

    public String getMessage() {
        return message;
    }

    public Throwable getE() {
        return e;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
