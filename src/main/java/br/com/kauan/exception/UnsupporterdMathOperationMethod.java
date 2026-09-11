package br.com.kauan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupporterdMathOperationMethod extends RuntimeException {
    public UnsupporterdMathOperationMethod(String message) {
        super(message);
    }
}
